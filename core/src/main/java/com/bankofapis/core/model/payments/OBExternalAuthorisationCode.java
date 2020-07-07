package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of authorisation flow requested.
 */
public enum OBExternalAuthorisationCode {
  
  ANY("Any"),
  
  SINGLE("Single");

  private String value;

  OBExternalAuthorisationCode(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OBExternalAuthorisationCode fromValue(String text) {
    for (OBExternalAuthorisationCode b : OBExternalAuthorisationCode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}