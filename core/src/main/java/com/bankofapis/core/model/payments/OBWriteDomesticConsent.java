package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * OBWriteDomesticConsent2
 */
@Validated

public class OBWriteDomesticConsent {
  @JsonProperty("Data")
  private OBWriteDataDomesticConsent data = null;

  @JsonProperty("Risk")
  private OBRisk risk = null;

  public OBWriteDomesticConsent data(OBWriteDataDomesticConsent data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @NotNull

  @Valid

  public OBWriteDataDomesticConsent getData() {
    return data;
  }

  public void setData(OBWriteDataDomesticConsent data) {
    this.data = data;
  }

  public OBWriteDomesticConsent risk(OBRisk risk) {
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
    OBWriteDomesticConsent obWriteDomesticConsent2 = (OBWriteDomesticConsent) o;
    return Objects.equals(this.data, obWriteDomesticConsent2.data) &&
        Objects.equals(this.risk, obWriteDomesticConsent2.risk);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, risk);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBWriteDomesticConsent2 {\n");

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