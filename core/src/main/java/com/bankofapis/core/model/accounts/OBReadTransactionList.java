package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OBReadTransactionList {

    @JsonProperty("Transaction")
    private List<OBReadTransaction> transactionList = null;

    public List<OBReadTransaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<OBReadTransaction> transactionList) {
        this.transactionList = transactionList;
    }
}