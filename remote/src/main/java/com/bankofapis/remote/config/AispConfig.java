package com.bankofapis.remote.config;

import org.springframework.beans.factory.annotation.Value;

public class AispConfig {

    @Value("${aisp.target.context}")
    private String aispContext;

    @Value("${aisp.target.baseUri}")
    private String aispBaseUri;

    @Value("${aisp.target.audience}")
    private String aispAudience;

    public String getAispContext() {
        return aispContext;
    }

    public String getAispBaseUri() {
        return aispBaseUri;
    }

    public String getAispAudience() {
        return aispAudience;
    }

}