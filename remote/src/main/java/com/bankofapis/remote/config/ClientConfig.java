package com.bankofapis.remote.config;

import org.springframework.beans.factory.annotation.Value;


public class ClientConfig {

    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    @Value("${client.redirectUri}")
    private String redirectUri;

    @Value("${client.state}")
    private String clientState;

    @Value("${client.authorizationUsername}")
    private String authorizationUsername;

    @Value("${client.authorizationAccount}")
    private String authorizationAccount;

    @Value("${client.financialId}")
    private String financialId;

    @Value("${client.tokenUrl}")
    private String tokenUrl;

    @Value("${client.initRunning:false}")
    private boolean initRunning;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getClientState() {
        return clientState;
    }

    public String getAuthorizationUsername() {
        return authorizationUsername;
    }

    public String getAuthorizationAccount() {
        return authorizationAccount;
    }

    public String getFinancialId() {
        return financialId;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public boolean isInitRunning() {
        return initRunning;
    }
}