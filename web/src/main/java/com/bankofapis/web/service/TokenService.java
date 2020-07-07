package com.bankofapis.web.service;

import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.remote.service.TokenRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;

public class TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);


    private TokenRemote tokenRemote;

    public TokenService(TokenRemote tokenRemote) {
        this.tokenRemote = tokenRemote;
    }

    public TokenResponse getTokenResponse(TokenRequest tokenRequest) {

      try {
          return tokenRemote.generateToken(tokenRequest);
      } catch (HttpClientErrorException ex) {
          logger.error(ex.getResponseBodyAsString(), ex);
          throw ex;
      }
    }

}