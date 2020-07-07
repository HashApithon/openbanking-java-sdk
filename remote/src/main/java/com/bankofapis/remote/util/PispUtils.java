package com.bankofapis.remote.util;

import com.bankofapis.remote.config.ClientConfig;
import com.bankofapis.remote.config.PispConfig;

public class PispUtils extends BaseApiUtils {

    private final PispConfig pispConfig;
    private final ClientConfig clientConfig;

    public PispUtils(PispConfig pispConfig, ClientConfig clientConfig) {
        this.pispConfig = pispConfig;
        this.clientConfig = clientConfig;
    }

    public String getUri(String path) {
        return String.format("%s%s%s", pispConfig.getPispBaseUri(), pispConfig.getPispContext(), path);
    }

    @Override
    public String createAuthorizeUrl(String consentId) {
        return String.format("%s?client_id=%s&response_type=code id_token&scope=openid payments&redirect_uri=%s&state=%s&request=%s&authorization_username=%s&authorization_account=%s",
                pispConfig.getPispAudience(),
                clientConfig.getClientId(),
                clientConfig.getRedirectUri(),
                clientConfig.getClientState(),
                consentId,
                clientConfig.getAuthorizationUsername(),
                clientConfig.getAuthorizationAccount());
    }
}