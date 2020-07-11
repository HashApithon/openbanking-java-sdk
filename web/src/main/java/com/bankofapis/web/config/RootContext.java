package com.bankofapis.web.config;

import com.bankofapis.remote.config.AispContext;
import com.bankofapis.remote.config.PispContext;
import com.bankofapis.remote.config.RemoteContext;
import com.bankofapis.remote.service.AispRemote;
import com.bankofapis.remote.service.PispRemote;
import com.bankofapis.remote.service.TokenRemote;
import com.bankofapis.web.filter.RedirectAuthorizationFilter;
import com.bankofapis.web.service.PispService;
import com.bankofapis.web.filter.HttpRequestFilter;
import com.bankofapis.web.service.AispService;
import com.bankofapis.web.service.TokenService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@Import({RemoteContext.class, AispContext.class, PispContext.class})
public class RootContext {

    @Bean
    public AispService aispService(AispRemote aispRemote, TokenRemote tokenRemote)  {
        return new AispService(aispRemote, tokenRemote);
    }

    @Bean
    public PispService pispService(PispRemote pispRemote)  { return new PispService(pispRemote); }

    @Bean
    public TokenService tokenService(TokenRemote tokenRemote) { return new TokenService(tokenRemote); }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> httpRequestFilter(){
        FilterRegistrationBean<OncePerRequestFilter> registrationBean
            = new FilterRegistrationBean<>();

        registrationBean.setFilter(new HttpRequestFilter());
        registrationBean.addUrlPatterns("/open-banking/*");

        registrationBean.setFilter(new RedirectAuthorizationFilter());
        registrationBean.addUrlPatterns("/open-banking/aisp/init");

        return registrationBean;
    }
}