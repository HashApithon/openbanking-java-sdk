package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class OBReadStandingOrder {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("Frequency")
    private String frequency;

    @JsonProperty("Reference")
    private String reference;

    @JsonProperty("FirstPaymentDateTime")
    private String firstPaymentDateTime;

    @JsonProperty("NextPaymentDateTime")
    private String nextPaymentDateTime;

    @JsonProperty("FinalPaymentDateTime")
    private String finalPaymentDateTime;

    @JsonProperty("StandingOrderStatusCode")
    private String standingOrderStatusCode;

    @JsonProperty("FirstPaymentAmount")
    private OBReadFirstPaymentAmount firstPaymentAmount;

    @JsonProperty("NextPaymentAmount")
    private OBReadNextPaymentAmount nextPaymentAmount;

    @JsonProperty("FinalPaymentAmount")
    private OBReadFinalPaymentAmount finalPaymentAmount;

    @JsonProperty("CreditorAccount")
    private OBReadCreditorAccount creditorAccount;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getFirstPaymentDateTime() {
        return firstPaymentDateTime;
    }

    public void setFirstPaymentDateTime(String firstPaymentDateTime) {
        this.firstPaymentDateTime = firstPaymentDateTime;
    }

    public String getNextPaymentDateTime() {
        return nextPaymentDateTime;
    }

    public void setNextPaymentDateTime(String nextPaymentDateTime) {
        this.nextPaymentDateTime = nextPaymentDateTime;
    }

    public String getFinalPaymentDateTime() {
        return finalPaymentDateTime;
    }

    public void setFinalPaymentDateTime(String finalPaymentDateTime) {
        this.finalPaymentDateTime = finalPaymentDateTime;
    }

    public String getStandingOrderStatusCode() {
        return standingOrderStatusCode;
    }

    public void setStandingOrderStatusCode(String standingOrderStatusCode) {
        this.standingOrderStatusCode = standingOrderStatusCode;
    }

    public OBReadFirstPaymentAmount getFirstPaymentAmount() {
        return firstPaymentAmount;
    }

    public void setFirstPaymentAmount(OBReadFirstPaymentAmount firstPaymentAmount) {
        this.firstPaymentAmount = firstPaymentAmount;
    }

    public OBReadNextPaymentAmount getNextPaymentAmount() {
        return nextPaymentAmount;
    }

    public void setNextPaymentAmount(OBReadNextPaymentAmount nextPaymentAmount) {
        this.nextPaymentAmount = nextPaymentAmount;
    }

    public OBReadFinalPaymentAmount getFinalPaymentAmount() {
        return finalPaymentAmount;
    }

    public void setFinalPaymentAmount(OBReadFinalPaymentAmount finalPaymentAmount) {
        this.finalPaymentAmount = finalPaymentAmount;
    }

    public OBReadCreditorAccount getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(OBReadCreditorAccount creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

}