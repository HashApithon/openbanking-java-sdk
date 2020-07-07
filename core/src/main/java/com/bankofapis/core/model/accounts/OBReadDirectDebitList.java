package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OBReadDirectDebitList {

    @JsonProperty("DirectDebit")
    private List<OBReadDirectDebit> directDebitList = null;

    public List<OBReadDirectDebit> getDirectDebitList() {
        return directDebitList;
    }

    public void setDirectDebitList(List<OBReadDirectDebit> directDebitList) {
        this.directDebitList = directDebitList;
    }
}

