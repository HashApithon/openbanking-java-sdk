package com.bankofapis.remote.config;

import com.bankofapis.remote.service.AispRemote;
import com.bankofapis.remote.util.AispUtils;
import com.bankofapis.remote.util.BaseApiUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


public class AispContext {

    @Bean
    public AispConfig aispConfig(){
        return new AispConfig();
    }

    @Bean("aispUtils")
    public BaseApiUtils aispUtil(AispConfig aispConfig, ClientConfig clientConfig) {
        return new AispUtils(aispConfig, clientConfig);
    }

    @Bean
    public AispRemote aispRemote(@Qualifier("securedRestTemplate") RestTemplate securedRestTemplate,
                                 @Qualifier("aispUtils") BaseApiUtils apiUtils) {
        return new AispRemote(securedRestTemplate, apiUtils);
    }
}