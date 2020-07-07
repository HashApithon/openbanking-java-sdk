package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the status of resource in code form.
 */
public enum OBExternalConsentStatusCode {
  
  AUTHORISED("Authorised"),
  
  AWAITINGAUTHORISATION("AwaitingAuthorisation"),
  
  CONSUMED("Consumed"),
  
  REJECTED("Rejected");

  private String value;

  OBExternalConsentStatusCode(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OBExternalConsentStatusCode fromValue(String text) {
    for (OBExternalConsentStatusCode b : OBExternalConsentStatusCode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}