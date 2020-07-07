package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the payment context
 */
public enum OBExternalPaymentContextCode {
  
  BILLPAYMENT("BillPayment"),
  
  ECOMMERCEGOODS("EcommerceGoods"),
  
  ECOMMERCESERVICES("EcommerceServices"),
  
  OTHER("Other"),
  
  PARTYTOPARTY("PartyToParty");

  private String value;

  OBExternalPaymentContextCode(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OBExternalPaymentContextCode fromValue(String text) {
    for (OBExternalPaymentContextCode b : OBExternalPaymentContextCode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}