package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OBWriteDataDomesticConsentResponse2
 */
@Validated
public class OBWriteDataDomesticConsentResponse {
    @JsonProperty("ConsentId")
    private String consentId = null;

    @JsonProperty("CreationDateTime")
    private OffsetDateTime creationDateTime = null;

    @JsonProperty("Status")
    private OBExternalConsentStatusCode status = null;

    @JsonProperty("StatusUpdateDateTime")
    private OffsetDateTime statusUpdateDateTime = null;

    @JsonProperty("CutOffDateTime")
    private OffsetDateTime cutOffDateTime = null;

    @JsonProperty("ExpectedExecutionDateTime")
    private OffsetDateTime expectedExecutionDateTime = null;

    @JsonProperty("ExpectedSettlementDateTime")
    private OffsetDateTime expectedSettlementDateTime = null;

    @JsonProperty("Charges")
    @Valid
    private List<OBCharge> charges = null;

    @JsonProperty("Initiation")
    private OBDomestic initiation = null;

    @JsonProperty("Authorisation")
    private OBAuthorisation authorisation = null;

    public OBWriteDataDomesticConsentResponse consentId(String consentId) {
        this.consentId = consentId;
        return this;
    }

    /**
     * OB: Unique identification as assigned by the ASPSP to uniquely identify the consent resource.
     *
     * @return consentId
     **/
    @NotNull

    @Size(min = 1, max = 128)
    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    public OBWriteDataDomesticConsentResponse creationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
        return this;
    }

    /**
     * Date and time at which the resource was created. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     *
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

    public OBWriteDataDomesticConsentResponse status(OBExternalConsentStatusCode status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
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

    public OBWriteDataDomesticConsentResponse statusUpdateDateTime(OffsetDateTime statusUpdateDateTime) {
        this.statusUpdateDateTime = statusUpdateDateTime;
        return this;
    }

    /**
     * Date and time at which the resource status was updated. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     *
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

    public OBWriteDataDomesticConsentResponse cutOffDateTime(OffsetDateTime cutOffDateTime) {
        this.cutOffDateTime = cutOffDateTime;
        return this;
    }

    /**
     * Specified cut-off date and time for the payment consent. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     *
     * @return cutOffDateTime
     **/

    @Valid

    public OffsetDateTime getCutOffDateTime() {
        return cutOffDateTime;
    }

    public void setCutOffDateTime(OffsetDateTime cutOffDateTime) {
        this.cutOffDateTime = cutOffDateTime;
    }

    public OBWriteDataDomesticConsentResponse expectedExecutionDateTime(OffsetDateTime expectedExecutionDateTime) {
        this.expectedExecutionDateTime = expectedExecutionDateTime;
        return this;
    }

    /**
     * Expected execution date and time for the payment resource. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     *
     * @return expectedExecutionDateTime
     **/

    @Valid

    public OffsetDateTime getExpectedExecutionDateTime() {
        return expectedExecutionDateTime;
    }

    public void setExpectedExecutionDateTime(OffsetDateTime expectedExecutionDateTime) {
        this.expectedExecutionDateTime = expectedExecutionDateTime;
    }

    public OBWriteDataDomesticConsentResponse expectedSettlementDateTime(OffsetDateTime expectedSettlementDateTime) {
        this.expectedSettlementDateTime = expectedSettlementDateTime;
        return this;
    }

    /**
     * Expected settlement date and time for the payment resource. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     *
     * @return expectedSettlementDateTime
     **/

    @Valid

    public OffsetDateTime getExpectedSettlementDateTime() {
        return expectedSettlementDateTime;
    }

    public void setExpectedSettlementDateTime(OffsetDateTime expectedSettlementDateTime) {
        this.expectedSettlementDateTime = expectedSettlementDateTime;
    }

    public OBWriteDataDomesticConsentResponse charges(List<OBCharge> charges) {
        this.charges = charges;
        return this;
    }

    public OBWriteDataDomesticConsentResponse addChargesItem(OBCharge chargesItem) {
        if (this.charges == null) {
            this.charges = new ArrayList<OBCharge>();
        }
        this.charges.add(chargesItem);
        return this;
    }

    /**
     * Set of elements used to provide details of a charge for the payment initiation.
     *
     * @return charges
     **/

    @Valid

    public List<OBCharge> getCharges() {
        return charges;
    }

    public void setCharges(List<OBCharge> charges) {
        this.charges = charges;
    }

    public OBWriteDataDomesticConsentResponse initiation(OBDomestic initiation) {
        this.initiation = initiation;
        return this;
    }

    /**
     * Get initiation
     *
     * @return initiation
     **/
    @NotNull

    @Valid

    public OBDomestic getInitiation() {
        return initiation;
    }

    public void setInitiation(OBDomestic initiation) {
        this.initiation = initiation;
    }

    public OBWriteDataDomesticConsentResponse authorisation(OBAuthorisation authorisation) {
        this.authorisation = authorisation;
        return this;
    }

    /**
     * Get authorisation
     *
     * @return authorisation
     **/

    @Valid

    public OBAuthorisation getAuthorisation() {
        return authorisation;
    }

    public void setAuthorisation(OBAuthorisation authorisation) {
        this.authorisation = authorisation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBWriteDataDomesticConsentResponse obWriteDataDomesticConsentResponse2 = (OBWriteDataDomesticConsentResponse) o;
        return Objects.equals(this.consentId, obWriteDataDomesticConsentResponse2.consentId) &&
                Objects.equals(this.creationDateTime, obWriteDataDomesticConsentResponse2.creationDateTime) &&
                Objects.equals(this.status, obWriteDataDomesticConsentResponse2.status) &&
                Objects.equals(this.statusUpdateDateTime, obWriteDataDomesticConsentResponse2.statusUpdateDateTime) &&
                Objects.equals(this.cutOffDateTime, obWriteDataDomesticConsentResponse2.cutOffDateTime) &&
                Objects.equals(this.expectedExecutionDateTime, obWriteDataDomesticConsentResponse2.expectedExecutionDateTime) &&
                Objects.equals(this.expectedSettlementDateTime, obWriteDataDomesticConsentResponse2.expectedSettlementDateTime) &&
                Objects.equals(this.charges, obWriteDataDomesticConsentResponse2.charges) &&
                Objects.equals(this.initiation, obWriteDataDomesticConsentResponse2.initiation) &&
                Objects.equals(this.authorisation, obWriteDataDomesticConsentResponse2.authorisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consentId, creationDateTime, status, statusUpdateDateTime, cutOffDateTime, expectedExecutionDateTime, expectedSettlementDateTime, charges, initiation, authorisation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBWriteDataDomesticConsentResponse2 {\n");

        sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
        sb.append("    creationDateTime: ").append(toIndentedString(creationDateTime)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusUpdateDateTime: ").append(toIndentedString(statusUpdateDateTime)).append("\n");
        sb.append("    cutOffDateTime: ").append(toIndentedString(cutOffDateTime)).append("\n");
        sb.append("    expectedExecutionDateTime: ").append(toIndentedString(expectedExecutionDateTime)).append("\n");
        sb.append("    expectedSettlementDateTime: ").append(toIndentedString(expectedSettlementDateTime)).append("\n");
        sb.append("    charges: ").append(toIndentedString(charges)).append("\n");
        sb.append("    initiation: ").append(toIndentedString(initiation)).append("\n");
        sb.append("    authorisation: ").append(toIndentedString(authorisation)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}