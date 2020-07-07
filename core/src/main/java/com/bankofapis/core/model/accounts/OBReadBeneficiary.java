package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class OBReadBeneficiary {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("BeneficiaryId")
    private String beneficiaryId;

    @JsonProperty("CreditorAccount")
    private OBReadCreditorAccount creditorAccount;

    @JsonProperty("Reference")
    private String reference;

    @JsonProperty("CreditorAgent")
    private OBReadCreditorAgent creditorAgent;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(String beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public OBReadCreditorAccount getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(OBReadCreditorAccount creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public OBReadCreditorAgent getCreditorAgent() {
        return creditorAgent;
    }

    public void setCreditorAgent(OBReadCreditorAgent creditorAgent) {
        this.creditorAgent = creditorAgent;
    }

}