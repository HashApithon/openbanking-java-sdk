package com.bankofapis.web.controller;

import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.web.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/token")
    public TokenResponse generateToken(@RequestBody TokenRequest tokenRequest) {
        return tokenService.getTokenResponse(tokenRequest);
    }
}