package com.bankofapis.core.model.common;

public class HttpRequestHeader {

    private String authorization;
    private String financialId;
    private String idempotencyKey;
    private String jwsSignature;

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
}