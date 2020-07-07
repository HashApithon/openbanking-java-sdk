package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Set of elements used to provide details of a charge for the payment initiation.
 */
@Validated
public class OBCharge {

  @JsonProperty("ChargeBearer")
  private OBChargeBearerTypeCode chargeBearer = null;

  @JsonProperty("Type")
  private String type = null;

  @JsonProperty("Amount")
  private OBChargeAmount amount = null;

  public OBCharge chargeBearer(OBChargeBearerTypeCode chargeBearer) {
    this.chargeBearer = chargeBearer;
    return this;
  }

  /**
   * Get chargeBearer
   * @return chargeBearer
  **/
  @NotNull
  @Valid
  public OBChargeBearerTypeCode getChargeBearer() {
    return chargeBearer;
  }

  public void setChargeBearer(OBChargeBearerTypeCode chargeBearer) {
    this.chargeBearer = chargeBearer;
  }

  public OBCharge type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @NotNull
  @Size(min=1,max=40)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public OBCharge amount(OBChargeAmount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @NotNull
  @Valid
  public OBChargeAmount getAmount() {
    return amount;
  }

  public void setAmount(OBChargeAmount amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBCharge obCharge2 = (OBCharge) o;
    return Objects.equals(this.chargeBearer, obCharge2.chargeBearer) &&
        Objects.equals(this.type, obCharge2.type) &&
        Objects.equals(this.amount, obCharge2.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chargeBearer, type, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBCharge2 {\n");

    sb.append("    chargeBearer: ").append(toIndentedString(chargeBearer)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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