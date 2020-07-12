package com.bankofapis.core.model.common;

public class Session {
    private String sessionId;
    private String paymentConsentId;
    private String idempotencyKey;
    private String paymentId;

    public String getSessionId() {
        return sessionId;
    }

    public String getPaymentConsentId() {
        return paymentConsentId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setPaymentConsentId(String paymentConsentId) {
        this.paymentConsentId = paymentConsentId;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId='" + sessionId + '\'' +
                ", paymentConsentId='" + paymentConsentId + '\'' +
                ", idempotencyKey='" + idempotencyKey + '\'' +
                ", paymentId='" + paymentId + '\'' +
                '}';
    }
}
