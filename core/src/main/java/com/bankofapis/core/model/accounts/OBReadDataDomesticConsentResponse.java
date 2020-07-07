package com.bankofapis.core.model.accounts;

import com.bankofapis.core.model.payments.OBExternalConsentStatusCode;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;


public class OBReadDataDomesticConsentResponse {

    @JsonProperty("ConsentId")
    private String consentId = null;

    @JsonProperty("CreationDateTime")
    private OffsetDateTime creationDateTime = null;

    @JsonProperty("Status")
    private OBExternalConsentStatusCode status = null;

    @JsonProperty("StatusUpdateDateTime")
    private OffsetDateTime statusUpdateDateTime = null;

    @JsonProperty("Permissions")
    private List<String> permissions = null;

    /**
     * OB: Unique identification as assigned by the ASPSP to uniquely identify the consent resource.
     * @return consentId
     **/
    @NotNull
    @Size(min=1,max=128)
    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    /**
     * Date and time at which the resource was created. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     * @return creationDateTime
     **/
    @NotNull
    @Valid
    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    /**
     * Get status
     * @return status
     **/
    @NotNull
    @Valid

    public OBExternalConsentStatusCode getStatus() {
        return status;
    }

    public void setStatus(OBExternalConsentStatusCode status) {
        this.status = status;
    }

    /**
     * Date and time at which the resource status was updated. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     * @return statusUpdateDateTime
     **/
    @NotNull
    @Valid
    public OffsetDateTime getStatusUpdateDateTime() {
        return statusUpdateDateTime;
    }

    public void setStatusUpdateDateTime(OffsetDateTime statusUpdateDateTime) {
        this.statusUpdateDateTime = statusUpdateDateTime;
    }

    @NotNull
    @Valid
    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}