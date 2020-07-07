package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class OBReadDataDomesticConsent {

    @JsonProperty("Permissions")
    private List<String> permissions = new ArrayList<>();

    @NotNull
    @Valid
    public List<String> getPermissions() { return  permissions; }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}