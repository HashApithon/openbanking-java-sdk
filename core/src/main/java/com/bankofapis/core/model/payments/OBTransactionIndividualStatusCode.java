package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the status of the payment information group.
 */
public enum OBTransactionIndividualStatusCode {
  
  ACCEPTEDSETTLEMENTCOMPLETED("AcceptedSettlementCompleted"),
  
  ACCEPTEDSETTLEMENTINPROCESS("AcceptedSettlementInProcess"),
  
  PENDING("Pending"),
  
  REJECTED("Rejected");

  private String value;

  OBTransactionIndividualStatusCode(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OBTransactionIndividualStatusCode fromValue(String text) {
    for (OBTransactionIndividualStatusCode b : OBTransactionIndividualStatusCode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}