package com.bankofapis.web.service;

import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.remote.config.ClientConfig;
import com.bankofapis.remote.service.TokenRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

public class TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);


    private TokenRemote tokenRemote;
    private ClientConfig clientConfig;

    public TokenService(TokenRemote tokenRemote, ClientConfig clientConfig) {
        this.tokenRemote = tokenRemote;
        this.clientConfig = clientConfig;
    }

    public TokenResponse getTokenResponse(TokenRequest tokenRequest) {

      try {
          return tokenRemote.generateToken(augmentRequest(tokenRequest));
      } catch (HttpClientErrorException ex) {
          logger.error(ex.getResponseBodyAsString(), ex);
          throw ex;
      }
    }

    private TokenRequest augmentRequest(TokenRequest tokenRequest) {
        if(StringUtils.isEmpty(tokenRequest.getCode()))
            return tokenRequest;

        if(Boolean.FALSE.equals(clientConfig.isInitRunning()) && StringUtils.isEmpty(tokenRequest.getClientId())) {
            throw new RuntimeException("SDK is not running in INIT mode");
        }

        tokenRequest.setClientId(clientConfig.getClientId());
        tokenRequest.setClientSecret(clientConfig.getClientSecret());
        tokenRequest.setRedirectUri(clientConfig.getRedirectUri());
        tokenRequest.setGrantType("authorization_code");
        tokenRequest.setCodeChallengeMethod("S256");
        return tokenRequest;
    }

}