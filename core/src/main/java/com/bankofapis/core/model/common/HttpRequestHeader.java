package com.bankofapis.core.model.common;

public class HttpRequestHeader {

    private String authorization;
    private String financialId;
    private String idempotencyKey;
    private String jwsSignature;
    private String sessionId;
    private String authorizationURL;

    public String getAuthorizationURL() {
        return authorizationURL;
    }

    public void setAuthorizationURL(String authorizationURL) {
        this.authorizationURL = authorizationURL;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getFinancialId() {
        return financialId;
    }

    public void setFinancialId(String financialId) {
        this.financialId = financialId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getJwsSignature() {
        return jwsSignature;
    }

    public void setJwsSignature(String jwsSignature) {
        this.jwsSignature = jwsSignature;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}