package com.bankofapis.web;

import com.bankofapis.core.model.common.HttpErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private ObjectMapper mapper = new ObjectMapper();

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<HttpErrorResponse> httpClientErrorException(
        HttpClientErrorException ex) throws Exception{

        log.debug("Invalid Request", ex);

        HttpErrorResponse errorResponse = parseExceptionMessage(ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = {HttpServerErrorException.class})
    public ResponseEntity<HttpErrorResponse> httpServerErrorException(
        HttpServerErrorException ex) throws Exception{

        log.debug("Internal Server Error", ex);

        HttpErrorResponse errorResponse = parseExceptionMessage(ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<HttpErrorResponse> invalidParams(Exception ex) {

        log.error("Exception occurred", ex);
        return new  ResponseEntity<>(new HttpErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(),
            "Internal Server Error: " + getCauseMessage(ex), ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private HttpErrorResponse parseExceptionMessage(HttpStatusCodeException ex) throws Exception {

        HttpErrorResponse errorBody;
        try {

            errorBody = mapper.readValue(ex.getResponseBodyAsString(), HttpErrorResponse.class);

        } catch (Exception e) {
            errorBody = new HttpErrorResponse("Server Error", "", ex.getResponseBodyAsString());
        }
        return errorBody;
    }

    private String getCauseMessage(Throwable t) {
        if (t.getCause() != null) {
            return t.getCause().getMessage();
        }
        return t.getMessage();
    }
}