package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the status of the authorisation flow in code form.
 */
public enum OBExternalStatusCode {
  
  AUTHORISED("Authorised"),
  
  AWAITINGFURTHERAUTHORISATION("AwaitingFurtherAuthorisation"),
  
  REJECTED("Rejected");

  private String value;

  OBExternalStatusCode(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OBExternalStatusCode fromValue(String text) {
    for (OBExternalStatusCode b : OBExternalStatusCode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}