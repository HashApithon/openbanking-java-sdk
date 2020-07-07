package com.bankofapis.remote.config;

import com.bankofapis.remote.service.PispRemote;
import com.bankofapis.remote.util.PispUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class PispContext {

    @Bean
    public PispConfig pispConfig(){
        return new PispConfig();
    }

    @Bean
    public PispUtils pispUtil(PispConfig pispConfig, ClientConfig clientConfig) {
        return new PispUtils(pispConfig, clientConfig);
    }

    @Bean
    public PispRemote pispRemote(@Qualifier("securedRestTemplate") RestTemplate securedRestTemplate,
                                 PispUtils pispUtil) {
        return  new PispRemote(securedRestTemplate, pispUtil);
    }
}