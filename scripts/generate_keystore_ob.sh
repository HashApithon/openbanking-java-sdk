#!/usr/bin/env bash

ARGUMENT_VALIDATION_FAIL=false

ENVIRONMENT="$1"
CERTIFICATE_TYPE="$2"
SOFTWARE_ID="$3"
INPUT_CERT_P12="$4"
INPUT_CERT_P12_PASSPHRASE="$5"
INPUT_CERT_KEY_ID="$6"
OUTPUT_JKS_NAME="$7"
OUTPUT_JKS_PASSPHRASE="$8"

if [ -z "$ENVIRONMENT" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the environment this is for (either prod or sandbox)"
elif [ "$ENVIRONMENT" != "prod" ] && [ "$ENVIRONMENT" != "sandbox" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "Only prod and sandbox are supported environments"
fi

if [ -z "$CERTIFICATE_TYPE" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the type of certificate (either transport or signing)"
elif [ "$CERTIFICATE_TYPE" != "transport" ] && [ "$CERTIFICATE_TYPE" != "signing" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "Only transport and signing are supported types"
fi

if [ -z "$SOFTWARE_ID" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the software id (aka. client id)"
fi

if [ -z "$INPUT_CERT_P12" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the path to the input .p12/.pfx"
fi

if [ -z "$INPUT_CERT_P12_PASSPHRASE" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the passphrase for the input .p12/.pfx"
fi

if [ -z "$INPUT_CERT_KEY_ID" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the key id (KID) from the OB Directory"
fi

if [ -z "$OUTPUT_JKS_NAME" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the output JKS name"
fi

if [ -z "$OUTPUT_JKS_PASSPHRASE" ]; then
	ARGUMENT_VALIDATION_FAIL=true
	echo "You must provide the output JKS passphrase"
fi

if [ "$ARGUMENT_VALIDATION_FAIL" = true ]; then
	echo "Example usage: $0 prod transport software_id my_new_transport_cert.p12 password_to_p12 the_cert_ob_key_id output_keystore_name.jks output_keystore_pass"
	exit 1
fi

DEST_ALIAS=""
if [ "$CERTIFICATE_TYPE" == "transport" ]; then
	DEST_ALIAS="$SOFTWARE_ID"
else
	DEST_ALIAS="$INPUT_CERT_KEY_ID"
fi

# extract cert
openssl pkcs12 -in "$INPUT_CERT_P12" -clcerts -nokeys -out cert.pem -passin "pass:$INPUT_CERT_P12_PASSPHRASE"

# drop bag attributes
openssl x509 -in cert.pem -out cert.pem

# extract key
openssl pkcs12 -in "$INPUT_CERT_P12" -nocerts -out key.pem -passin "pass:$INPUT_CERT_P12_PASSPHRASE" -passout "pass:$INPUT_CERT_P12_PASSPHRASE"

# remove key passphrase
openssl rsa -in key.pem -out key.pem -passin "pass:$INPUT_CERT_P12_PASSPHRASE"


# add signing chain for transport certificates
if [ "$CERTIFICATE_TYPE" == "transport" ]; then
	cat "ob_signing_certs/ob_$ENVIRONMENT_issuing.pem" >> cert.pem
	cat "ob_signing_certs/ob_$ENVIRONMENT_root.pem" >> cert.pem
fi

# recombine key and cert
openssl pkcs12 -export -out cert.pfx -inkey key.pem -in cert.pem -name cert -passout "pass:$OUTPUT_JKS_PASSPHRASE"

# create jks
keytool -importkeystore -srckeystore cert.pfx -srcstoretype pkcs12 -alias cert -destkeystore "$OUTPUT_JKS_NAME" -deststoretype JKS -destalias "$DEST_ALIAS" -srcstorepass "$OUTPUT_JKS_PASSPHRASE" -deststorepass "$OUTPUT_JKS_PASSPHRASE"

rm -f cert.pfx
rm -f cert.pem
rm -f key.pem

echo "Done."