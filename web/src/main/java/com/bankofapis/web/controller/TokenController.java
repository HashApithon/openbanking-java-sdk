package com.bankofapis.web.controller;

import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.web.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TokenController {

    private TokenService tokenService;
    private ObjectMapper mapper;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public TokenResponse generateToken(@RequestParam Map tokenRequest) {
        return tokenService.getTokenResponse(mapper.convertValue(tokenRequest, TokenRequest.class));
    }
}