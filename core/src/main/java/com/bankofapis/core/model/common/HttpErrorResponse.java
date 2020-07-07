package com.bankofapis.core.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpErrorResponse {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Message")
    private String message;

    public HttpErrorResponse(String code) {
        this.code = code;
    }

    public HttpErrorResponse(String code, String id) {
        this.code = code;
        this.id = id;
    }

    public HttpErrorResponse(String code, String id, String message) {
        this.code = code;
        this.id = id;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}