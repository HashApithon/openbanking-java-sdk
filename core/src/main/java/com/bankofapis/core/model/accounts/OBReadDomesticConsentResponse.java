package com.bankofapis.core.model.accounts;

import com.bankofapis.core.model.common.Links;
import com.bankofapis.core.model.common.Meta;
import com.bankofapis.core.model.payments.OBRisk;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OBReadDomesticConsentResponse {

    @JsonProperty("Data")
    private OBReadDataDomesticConsentResponse data = null;

    @JsonProperty("Risk")
    private OBRisk risk = null;

    @JsonProperty("Links")
    private Links links = null;

    @JsonProperty("Meta")
    private Meta meta = null;

    public OBReadDataDomesticConsentResponse getData() {
        return data;
    }

    public OBRisk getRisk() {
        return risk;
    }

    public Links getLinks() {
        return links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setData(OBReadDataDomesticConsentResponse data) {
        this.data = data;
    }

    public void setRisk(OBRisk risk) {
        this.risk = risk;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}