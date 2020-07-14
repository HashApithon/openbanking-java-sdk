package com.bankofapis.core.model.common;


public final class Constants {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String FINANCIAL_ID_HEADER = "x-fapi-financial-id";
    public static final String IDEMPOTENCY_KEY_HEADER = "x-idempotency-key";
    public static final String JWS_SIGNATURE_HEADER = "x-jws-signature";
    public static final String GRANT_TYPE_HEADER = "grant_type";
    public static final String CLIENT_CRED_GRANT_TYPE_VALUE = "client_credentials";
    public static final String CLIENT_ID_HEADER = "client_id";
    public static final String SCOPE_HEADER = "scope";
    public static final String SCOPE_ACCOUNT_VALUE = "accounts";
    public static final String SCOPE_PAYMENT_VALUE = "payments";

    public static final String CLIENT_SECRET_HEADER = "client_secret";
    public static final String REDIRECT_URI_HEADER = "redirect_uri";
    public static final String CODE_HEADER = "code";
    public static final String CODE_VERIFIER_HEADER = "code_verifier";
    public static final String CODE_CHALLENGE_METHOD_HEADER = "code_challenge_method";
    public static final String CONSENT_ID_HEADER = "request";

    public static final String SESSION_ID = "session_id";
}