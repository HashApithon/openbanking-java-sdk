package com.bankofapis.web.service;

import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.core.model.common.Session;
import com.bankofapis.core.model.payments.OBWriteDomestic;
import com.bankofapis.core.model.payments.OBWriteDomesticConsent;
import com.bankofapis.core.model.payments.OBWriteDomesticConsentResponse;
import com.bankofapis.core.model.payments.OBWriteDomesticResponse;
import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.remote.config.ClientConfig;
import com.bankofapis.remote.service.PispRemote;
import com.bankofapis.remote.service.TokenRemote;
import com.bankofapis.web.filter.HttpRequestContext;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;

import static com.bankofapis.core.model.common.Constants.CLIENT_CRED_GRANT_TYPE_VALUE;
import static com.bankofapis.core.model.common.Constants.SCOPE_PAYMENT_VALUE;


public class PispService {

    private static final Logger logger = LoggerFactory.getLogger(PispService.class);

    private PispRemote pispRemote;
    private TokenRemote tokenRemote;
    private ClientConfig clientConfig;
    private ObjectMapper mapper;

    public PispService(PispRemote pispRemote, TokenRemote tokenRemote, ClientConfig clientConfig) {
        this.pispRemote = pispRemote;
        this.tokenRemote = tokenRemote;
        this.clientConfig = clientConfig;
        mapper = new ObjectMapper();
    }

    public String initialize() throws Exception {
        try {
            checkInitMode();
            TokenRequest tokenRequest = new TokenRequest();
            tokenRequest.setClientId(clientConfig.getClientId());
            tokenRequest.setClientSecret(clientConfig.getClientSecret());
            tokenRequest.setScope(SCOPE_PAYMENT_VALUE);
            tokenRequest.setGrantType(CLIENT_CRED_GRANT_TYPE_VALUE);
            TokenResponse tokenResponse = tokenRemote.generateToken(tokenRequest);

            HttpRequestHeader httpRequestHeader = HttpRequestContext.get();
            Session session = (Session) CacheManager.getSessionCache().getUnchecked(httpRequestHeader.getSessionId());
            httpRequestHeader.setAuthorization(tokenResponse.getTokenType() + " " + tokenResponse.getAccessToken());
            augmentHeader(httpRequestHeader, session);
            HttpRequestContext.set(httpRequestHeader);

            OBWriteDomesticConsent obWriteDomesticConsent = mapper.readValue(createPispPayload(null), OBWriteDomesticConsent.class);
            OBWriteDomesticConsentResponse consentResponse = pispRemote.createPaymentConsent(obWriteDomesticConsent, HttpRequestContext.get());
            session.setPaymentConsentId(consentResponse.getData().getConsentId());
            CacheManager.getSessionCache().put(httpRequestHeader.getSessionId(), session);

            return createAuthorizeUri(consentResponse.getData().getConsentId());
        } catch (HttpStatusCodeException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBWriteDomesticConsentResponse createPaymentConsent(OBWriteDomesticConsent obWriteDomesticConsent2) {
        return pispRemote.createPaymentConsent(obWriteDomesticConsent2, HttpRequestContext.get());
    }

    public String createAuthorizeUri(String consentId) {
        return pispRemote.createAuthorizeUri(consentId);
    }

    public OBWriteDomesticResponse createDomesticPayment(OBWriteDomestic obWriteDomestic2) throws Exception {

        try {
           return augmentPayment(obWriteDomestic2);
        } catch (HttpStatusCodeException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBWriteDomesticResponse getPaymentStatus(String paymentId) {
        try {
            return pispRemote.getPaymentStatus(paymentId, HttpRequestContext.get());
        } catch (HttpStatusCodeException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    private OBWriteDomesticResponse augmentPayment(OBWriteDomestic obWriteDomestic) throws Exception{
        if(obWriteDomestic == null) {
            checkInitMode();
            HttpRequestHeader httpRequestHeader = HttpRequestContext.get();
            Session session = (Session)CacheManager.getSessionCache().getUnchecked(httpRequestHeader.getSessionId());
            augmentHeader(httpRequestHeader, session);
            HttpRequestContext.set(httpRequestHeader);

            OBWriteDomestic obWriteDomesticPayload = mapper.readValue(createPispPayload(session.getPaymentConsentId()), OBWriteDomestic.class);
            OBWriteDomesticResponse paymentResponse = pispRemote.createDomesticPayment(obWriteDomesticPayload, HttpRequestContext.get());
            session.setPaymentId(paymentResponse.getData().getDomesticPaymentId());
            CacheManager.getSessionCache().put(httpRequestHeader.getSessionId(), session);
            return paymentResponse;

        } else {
            return pispRemote.createDomesticPayment(obWriteDomestic, HttpRequestContext.get());
        }
    }

    private void checkInitMode() {
        if(Boolean.FALSE.equals(clientConfig.isInitRunning())) {
            throw new RuntimeException("SDK is not running in INIT mode");
        }

    }

    private void augmentHeader(HttpRequestHeader httpRequestHeader, Session session) {
        httpRequestHeader.setFinancialId(clientConfig.getFinancialId());
        httpRequestHeader.setJwsSignature("DUMMY_SIG");
        httpRequestHeader.setIdempotencyKey(session.getIdempotencyKey());
    }

    private String createPispPayload(String consentId) {
        String consentString = "";
        if(!StringUtils.isEmpty(consentId)) {
            consentString = "\"ConsentId\":\""+consentId+"\",";
        }
        return "{\n" +
                "  \"Data\": {\n" +
                consentString +
                "    \"Initiation\": {\n" +
                "      \"InstructionIdentification\": \"instr-identification\",\n" +
                "      \"EndToEndIdentification\": \"e2e-identification\",\n" +
                "      \"InstructedAmount\": {\n" +
                "        \"Amount\": \"1.00\",\n" +
                "        \"Currency\": \"GBP\"\n" +
                "      },\n" +
                "      \"DebtorAccount\": null,\n" +
                "      \"CreditorAccount\": {\n" +
                "        \"SchemeName\": \"IBAN\",\n" +
                "        \"Identification\": \"BE56456394728288\",\n" +
                "        \"Name\": \"ACME DIY\",\n" +
                "        \"SecondaryIdentification\": \"secondary-identif\"\n" +
                "      },\n" +
                "      \"RemittanceInformation\": {\n" +
                "        \"Unstructured\": \"Tools\",\n" +
                "        \"Reference\": \"Tools\"\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"Risk\": {\n" +
                "    \"PaymentContextCode\": \"EcommerceGoods\",\n" +
                "    \"MerchantCategoryCode\": null,\n" +
                "    \"MerchantCustomerIdentification\": null,\n" +
                "    \"DeliveryAddress\": null\n" +
                "  }\n" +
                "}\n";
    }
}