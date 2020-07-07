package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OBReadAccountList {


    @JsonProperty("Account")
    private List<OBReadAccountInformation> account = null;

    public List<OBReadAccountInformation> getAccount() {
        return account;
    }

    public void setAccount(List<OBReadAccountInformation> account) {
        this.account = account;
    }
}