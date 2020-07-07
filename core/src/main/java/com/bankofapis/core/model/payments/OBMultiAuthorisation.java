package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * The multiple authorisation flow response from the ASPSP.
 */
@Validated
public class OBMultiAuthorisation {

    @JsonProperty("Status")
    private OBExternalStatusCode status = null;

    @JsonProperty("NumberRequired")
    private Integer numberRequired = null;

    @JsonProperty("NumberReceived")
    private Integer numberReceived = null;

    @JsonProperty("LastUpdateDateTime")
    private OffsetDateTime lastUpdateDateTime = null;

    @JsonProperty("ExpirationDateTime")
    private OffsetDateTime expirationDateTime = null;

    public OBMultiAuthorisation status(OBExternalStatusCode status) {
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
    public OBExternalStatusCode getStatus() {
        return status;
    }

    public void setStatus(OBExternalStatusCode status) {
        this.status = status;
    }

    public OBMultiAuthorisation numberRequired(Integer numberRequired) {
        this.numberRequired = numberRequired;
        return this;
    }

    /**
     * Number of authorisations required for payment order (total required at the start of the multi authorisation journey).
     *
     * @return numberRequired
     **/

    public Integer getNumberRequired() {
        return numberRequired;
    }

    public void setNumberRequired(Integer numberRequired) {
        this.numberRequired = numberRequired;
    }

    public OBMultiAuthorisation numberReceived(Integer numberReceived) {
        this.numberReceived = numberReceived;
        return this;
    }

    /**
     * Number of authorisations required for payment order (total required at the start of the multi authorisation journey).
     *
     * @return numberReceived
     **/

    public Integer getNumberReceived() {
        return numberReceived;
    }

    public void setNumberReceived(Integer numberReceived) {
        this.numberReceived = numberReceived;
    }

    public OBMultiAuthorisation lastUpdateDateTime(OffsetDateTime lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
        return this;
    }

    /**
     * Last date and time at the authorisation flow was updated. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     *
     * @return lastUpdateDateTime
     **/

    @Valid
    public OffsetDateTime getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(OffsetDateTime lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public OBMultiAuthorisation expirationDateTime(OffsetDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
        return this;
    }

    /**
     * Date and time at which the requested authorisation flow must be completed. All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
     *
     * @return expirationDateTime
     **/

    @Valid
    public OffsetDateTime getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(OffsetDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBMultiAuthorisation obMultiAuthorisation1 = (OBMultiAuthorisation) o;
        return Objects.equals(this.status, obMultiAuthorisation1.status) &&
                Objects.equals(this.numberRequired, obMultiAuthorisation1.numberRequired) &&
                Objects.equals(this.numberReceived, obMultiAuthorisation1.numberReceived) &&
                Objects.equals(this.lastUpdateDateTime, obMultiAuthorisation1.lastUpdateDateTime) &&
                Objects.equals(this.expirationDateTime, obMultiAuthorisation1.expirationDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, numberRequired, numberReceived, lastUpdateDateTime, expirationDateTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBMultiAuthorisation1 {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    numberRequired: ").append(toIndentedString(numberRequired)).append("\n");
        sb.append("    numberReceived: ").append(toIndentedString(numberReceived)).append("\n");
        sb.append("    lastUpdateDateTime: ").append(toIndentedString(lastUpdateDateTime)).append("\n");
        sb.append("    expirationDateTime: ").append(toIndentedString(expirationDateTime)).append("\n");
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