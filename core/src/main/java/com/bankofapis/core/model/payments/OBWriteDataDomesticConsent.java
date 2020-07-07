package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * OBWriteDataDomesticConsent2
 */
@Validated
public class OBWriteDataDomesticConsent {

  @JsonProperty("Initiation")
  private OBDomestic initiation = null;

  @JsonProperty("Authorisation")
  private OBAuthorisation authorisation = null;

  public OBWriteDataDomesticConsent initiation(OBDomestic initiation) {
    this.initiation = initiation;
    return this;
  }

  /**
   * Get initiation
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

  public OBWriteDataDomesticConsent authorisation(OBAuthorisation authorisation) {
    this.authorisation = authorisation;
    return this;
  }

  /**
   * Get authorisation
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
    OBWriteDataDomesticConsent obWriteDataDomesticConsent2 = (OBWriteDataDomesticConsent) o;
    return Objects.equals(this.initiation, obWriteDataDomesticConsent2.initiation) &&
        Objects.equals(this.authorisation, obWriteDataDomesticConsent2.authorisation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initiation, authorisation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBWriteDataDomesticConsent2 {\n");

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