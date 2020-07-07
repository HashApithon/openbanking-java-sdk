package com.bankofapis.remote.service;

import com.bankofapis.remote.config.ClientConfig;
import com.bankofapis.remote.util.TokenUtils;
import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TokenRemote {

    private static final Logger logger = LoggerFactory.getLogger(AispRemote.class);

    private RestTemplate securedRestTemplate;
    private TokenUtils tokenUtil;
    private ClientConfig clientConfig;


    public TokenRemote(RestTemplate securedRestTemplate, TokenUtils tokenUtil, ClientConfig clientConfig) {
        this.securedRestTemplate = securedRestTemplate;
        this.tokenUtil = tokenUtil;
        this.clientConfig = clientConfig;
    }

    public TokenResponse generateToken(TokenRequest requestToken) {

            ResponseEntity<TokenResponse> accessTokenResponse = securedRestTemplate.postForEntity(clientConfig.getTokenUrl(),
                    tokenUtil.createTokenObject(requestToken), TokenResponse.class);

            return accessTokenResponse.getBody();

    }
}