package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OBReadBeneficiaryList {

    @JsonProperty("Beneficiary")
    private List<OBReadBeneficiary> beneficiaryList = null;

    public List<OBReadBeneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public void setBeneficiaryList(List<OBReadBeneficiary> beneficiaryList) {
        this.beneficiaryList = beneficiaryList;
    }
}