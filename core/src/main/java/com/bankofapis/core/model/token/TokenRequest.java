package com.bankofapis.core.model.token;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TokenRequest {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("redirect_uri")
    private String redirectUri;

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("code")
    private String code;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("code_verifier")
    private String codeVerifier;

    @JsonProperty("code_challenge_method")
    private String codeChallengeMethod;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getCode() {
        return code;
    }

    public String getScope() {
        return scope;
    }

    public String getCodeVerifier() {
        return codeVerifier;
    }

    public String getCodeChallengeMethod() {
        return codeChallengeMethod;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setCodeVerifier(String codeVerifier) {
        this.codeVerifier = codeVerifier;
    }

    public void setCodeChallengeMethod(String codeChallengeMethod) {
        this.codeChallengeMethod = codeChallengeMethod;
    }
}