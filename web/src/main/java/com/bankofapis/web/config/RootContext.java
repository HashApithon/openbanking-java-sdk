package com.bankofapis.web.config;

import com.bankofapis.remote.config.AispContext;
import com.bankofapis.remote.config.ClientConfig;
import com.bankofapis.remote.config.PispContext;
import com.bankofapis.remote.config.RemoteContext;
import com.bankofapis.remote.service.AispRemote;
import com.bankofapis.remote.service.PispRemote;
import com.bankofapis.remote.service.TokenRemote;
import com.bankofapis.web.service.CacheManager;
import com.bankofapis.web.service.PispService;
import com.bankofapis.web.filter.HttpRequestFilter;
import com.bankofapis.web.service.AispService;
import com.bankofapis.web.service.TokenService;
import com.google.common.cache.LoadingCache;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@Import({RemoteContext.class, AispContext.class, PispContext.class})
public class RootContext {

    @Bean
    public AispService aispService(AispRemote aispRemote,
                                   TokenRemote tokenRemote,
                                   ClientConfig clientConfig)  {
        return new AispService(aispRemote, tokenRemote, clientConfig);
    }

    @Bean
    public PispService pispService(PispRemote pispRemote,
                                   TokenRemote tokenRemote,
                                   ClientConfig clientConfig)  {
        return new PispService(pispRemote, tokenRemote, clientConfig);

    }

    @Bean
    public TokenService tokenService(TokenRemote tokenRemote, ClientConfig clientConfig) { return new TokenService(tokenRemote, clientConfig); }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> httpRequestFilter(){
        FilterRegistrationBean<OncePerRequestFilter> registrationBean
            = new FilterRegistrationBean<>();

        registrationBean.setFilter(new HttpRequestFilter());
        registrationBean.addUrlPatterns("/open-banking/*");

        return registrationBean;
    }
}