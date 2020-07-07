package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OBReadBalanceList {

    @JsonProperty("Balance")
    private List<OBReadBalance> account = null;

    public List<OBReadBalance> getAccount() {
        return account;
    }

    public void setAccount(List<OBReadBalance> account) {
        this.account = account;
    }
}