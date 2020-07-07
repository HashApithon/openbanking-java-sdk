package com.bankofapis.core.model.payments;

import com.bankofapis.core.model.common.Links;
import com.bankofapis.core.model.common.Meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * OBWriteDomesticConsentResponse2
 */
@Validated

public class OBWriteDomesticConsentResponse {
  @JsonProperty("Data")
  private OBWriteDataDomesticConsentResponse data = null;

  @JsonProperty("Risk")
  private OBRisk risk = null;

  @JsonProperty("Links")
  private Links links = null;

  @JsonProperty("Meta")
  private Meta meta = null;

  public OBWriteDomesticConsentResponse data(OBWriteDataDomesticConsentResponse data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @NotNull

  @Valid

  public OBWriteDataDomesticConsentResponse getData() {
    return data;
  }

  public void setData(OBWriteDataDomesticConsentResponse data) {
    this.data = data;
  }

  public OBWriteDomesticConsentResponse risk(OBRisk risk) {
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

  public OBWriteDomesticConsentResponse links(Links links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
  **/
  @NotNull

  @Valid

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }

  public OBWriteDomesticConsentResponse meta(Meta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * @return meta
  **/
  @NotNull

  @Valid

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBWriteDomesticConsentResponse obWriteDomesticConsentResponse2 = (OBWriteDomesticConsentResponse) o;
    return Objects.equals(this.data, obWriteDomesticConsentResponse2.data) &&
        Objects.equals(this.risk, obWriteDomesticConsentResponse2.risk) &&
        Objects.equals(this.links, obWriteDomesticConsentResponse2.links) &&
        Objects.equals(this.meta, obWriteDomesticConsentResponse2.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, risk, links, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBWriteDomesticConsentResponse2 {\n");

    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    risk: ").append(toIndentedString(risk)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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