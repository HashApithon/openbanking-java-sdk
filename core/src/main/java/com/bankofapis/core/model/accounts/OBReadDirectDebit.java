package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OBReadDirectDebit {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("MandateIdentification")
    private String mandateIdentification;

    @JsonProperty("DirectDebitStatusCode")
    private String directDebitStatusCode;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("PreviousPaymentDateTime")
    private String previousPaymentDateTime;

    @JsonProperty("PreviousPaymentAmount")
    private OBReadPreviousPaymentAmount previousPaymentAmount;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMandateIdentification() {
        return mandateIdentification;
    }

    public void setMandateIdentification(String mandateIdentification) {
        this.mandateIdentification = mandateIdentification;
    }

    public String getDirectDebitStatusCode() {
        return directDebitStatusCode;
    }

    public void setDirectDebitStatusCode(String directDebitStatusCode) {
        this.directDebitStatusCode = directDebitStatusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreviousPaymentDateTime() {
        return previousPaymentDateTime;
    }

    public void setPreviousPaymentDateTime(String previousPaymentDateTime) {
        this.previousPaymentDateTime = previousPaymentDateTime;
    }

    public OBReadPreviousPaymentAmount getPreviousPaymentAmount() {
        return previousPaymentAmount;
    }

    public void setPreviousPaymentAmount(OBReadPreviousPaymentAmount previousPaymentAmount) {
        this.previousPaymentAmount = previousPaymentAmount;
    }

}

