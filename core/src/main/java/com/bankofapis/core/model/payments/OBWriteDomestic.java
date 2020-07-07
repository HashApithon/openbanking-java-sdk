package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * OBWriteDomestic2
 */
@Validated
public class OBWriteDomestic {
    @JsonProperty("Data")
    private OBWriteDataDomestic data = null;

    @JsonProperty("Risk")
    private OBRisk risk = null;

    public OBWriteDomestic data(OBWriteDataDomestic data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @NotNull

    @Valid

    public OBWriteDataDomestic getData() {
        return data;
    }

    public void setData(OBWriteDataDomestic data) {
        this.data = data;
    }

    public OBWriteDomestic risk(OBRisk risk) {
        this.risk = risk;
        return this;
    }

    /**
     * Get risk
     *
     * @return risk
     **/
    @NotNull

    @Valid

    public OBRisk getRisk() {
        return risk;
    }

    public void setRisk(OBRisk risk) {
        this.risk = risk;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBWriteDomestic obWriteDomestic2 = (OBWriteDomestic) o;
        return Objects.equals(this.data, obWriteDomestic2.data) &&
                Objects.equals(this.risk, obWriteDomestic2.risk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, risk);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBWriteDomestic2 {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    risk: ").append(toIndentedString(risk)).append("\n");
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