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
 * OBWriteDataDomesticResponse2
 */
@Validated
public class OBWriteDataDomesticResponse {

    @JsonProperty("DomesticPaymentId")
    private String domesticPaymentId = null;

    @JsonProperty("ConsentId")
    private String consentId = null;

    @JsonProperty("CreationDateTime")
    private OffsetDateTime creationDateTime = null;

    @JsonProperty("Status")
    private OBTransactionIndividualStatusCode status = null;

    @JsonProperty("StatusUpdateDateTime")
    private OffsetDateTime statusUpdateDateTime = null;

    @JsonProperty("ExpectedExecutionDateTime")
    private OffsetDateTime expectedExecutionDateTime = null;

    @JsonProperty("ExpectedSettlementDateTime")
    private OffsetDateTime expectedSettlementDateTime = null;

    @JsonProperty("Charges")
    @Valid
    private List<OBCharge> charges = null;

    @JsonProperty("Initiation")
    private OBDomestic initiation = null;

    @JsonProperty("MultiAuthorisation")
    private OBMultiAuthorisation multiAuthorisation = null;

    public OBWriteDataDomesticResponse domesticPaymentId(String domesticPaymentId) {
        this.domesticPaymentId = domesticPaymentId;
        return this;
    }

    /**
     * OB: Unique identification as assigned by the ASPSP to uniquely identify the domestic payment resource.
     *
     * @return domesticPaymentId
     **/
    @NotNull

    @Size(min = 1, max = 40)
    public String getDomesticPaymentId() {
        return domesticPaymentId;
    }

    public void setDomesticPaymentId(String domesticPaymentId) {
        this.domesticPaymentId = domesticPaymentId;
    }

    public OBWriteDataDomesticResponse consentId(String consentId) {
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

    public OBWriteDataDomesticResponse creationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
        return this;
    }

    /**
     * Date and time at which the message was created. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
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

    public OBWriteDataDomesticResponse status(OBTransactionIndividualStatusCode status) {
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

    public OBTransactionIndividualStatusCode getStatus() {
        return status;
    }

    public void setStatus(OBTransactionIndividualStatusCode status) {
        this.status = status;
    }

    public OBWriteDataDomesticResponse statusUpdateDateTime(OffsetDateTime statusUpdateDateTime) {
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

    public OBWriteDataDomesticResponse expectedExecutionDateTime(OffsetDateTime expectedExecutionDateTime) {
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

    public OBWriteDataDomesticResponse expectedSettlementDateTime(OffsetDateTime expectedSettlementDateTime) {
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

    public OBWriteDataDomesticResponse charges(List<OBCharge> charges) {
        this.charges = charges;
        return this;
    }

    public OBWriteDataDomesticResponse addChargesItem(OBCharge chargesItem) {
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

    public OBWriteDataDomesticResponse initiation(OBDomestic initiation) {
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

    public OBWriteDataDomesticResponse multiAuthorisation(OBMultiAuthorisation multiAuthorisation) {
        this.multiAuthorisation = multiAuthorisation;
        return this;
    }

    /**
     * Get multiAuthorisation
     *
     * @return multiAuthorisation
     **/

    @Valid

    public OBMultiAuthorisation getMultiAuthorisation() {
        return multiAuthorisation;
    }

    public void setMultiAuthorisation(OBMultiAuthorisation multiAuthorisation) {
        this.multiAuthorisation = multiAuthorisation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBWriteDataDomesticResponse obWriteDataDomesticResponse2 = (OBWriteDataDomesticResponse) o;
        return Objects.equals(this.domesticPaymentId, obWriteDataDomesticResponse2.domesticPaymentId) &&
                Objects.equals(this.consentId, obWriteDataDomesticResponse2.consentId) &&
                Objects.equals(this.creationDateTime, obWriteDataDomesticResponse2.creationDateTime) &&
                Objects.equals(this.status, obWriteDataDomesticResponse2.status) &&
                Objects.equals(this.statusUpdateDateTime, obWriteDataDomesticResponse2.statusUpdateDateTime) &&
                Objects.equals(this.expectedExecutionDateTime, obWriteDataDomesticResponse2.expectedExecutionDateTime) &&
                Objects.equals(this.expectedSettlementDateTime, obWriteDataDomesticResponse2.expectedSettlementDateTime) &&
                Objects.equals(this.charges, obWriteDataDomesticResponse2.charges) &&
                Objects.equals(this.initiation, obWriteDataDomesticResponse2.initiation) &&
                Objects.equals(this.multiAuthorisation, obWriteDataDomesticResponse2.multiAuthorisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domesticPaymentId, consentId, creationDateTime, status, statusUpdateDateTime, expectedExecutionDateTime, expectedSettlementDateTime, charges, initiation, multiAuthorisation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBWriteDataDomesticResponse2 {\n");

        sb.append("    domesticPaymentId: ").append(toIndentedString(domesticPaymentId)).append("\n");
        sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
        sb.append("    creationDateTime: ").append(toIndentedString(creationDateTime)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusUpdateDateTime: ").append(toIndentedString(statusUpdateDateTime)).append("\n");
        sb.append("    expectedExecutionDateTime: ").append(toIndentedString(expectedExecutionDateTime)).append("\n");
        sb.append("    expectedSettlementDateTime: ").append(toIndentedString(expectedSettlementDateTime)).append("\n");
        sb.append("    charges: ").append(toIndentedString(charges)).append("\n");
        sb.append("    initiation: ").append(toIndentedString(initiation)).append("\n");
        sb.append("    multiAuthorisation: ").append(toIndentedString(multiAuthorisation)).append("\n");
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