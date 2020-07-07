package com.bankofapis.remote.config;

import com.bankofapis.remote.service.TokenRemote;
import com.bankofapis.remote.util.TokenUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class TokenContext {


    @Bean
    public TokenRemote tokenRemote(@Qualifier("securedRestTemplate") RestTemplate securedRestTemplate,
                                   TokenUtils tokenUtil,
                                   ClientConfig clientConfig) {
        return new TokenRemote(securedRestTemplate, tokenUtil, clientConfig);
    }

    @Bean
    public TokenUtils tokenUtil() {
        return new TokenUtils();
    }

}