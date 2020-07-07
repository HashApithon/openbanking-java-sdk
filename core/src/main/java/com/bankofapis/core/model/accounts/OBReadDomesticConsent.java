package com.bankofapis.core.model.accounts;

import com.bankofapis.core.model.payments.OBRisk;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;


public class OBReadDomesticConsent {

    @JsonProperty("Data")
    private OBReadDataDomesticConsent data = null;

    @JsonProperty("Risk")
    private OBRisk risk = null;

    /**
     * Get data
     * @return data
     **/
    @NotNull
    @Valid
    public OBReadDataDomesticConsent getData() {
        return data;
    }

    public void setData(OBReadDataDomesticConsent data) {
        this.data = data;
    }

    public OBReadDomesticConsent risk(OBRisk risk) {
        this.risk = risk;
        return this;
    }

    /**
     * Get risk
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
        OBReadDomesticConsent obReadDomestic2 = (OBReadDomesticConsent) o;
        return Objects.equals(this.data, obReadDomestic2.data) &&
                Objects.equals(this.risk, obReadDomestic2.risk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, risk);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBReadDomestic2 {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    risk: ").append(toIndentedString(risk)).append("\n");
        sb.append("}");
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