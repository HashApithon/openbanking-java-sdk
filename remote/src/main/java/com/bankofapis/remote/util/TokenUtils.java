package com.bankofapis.remote.util;

import com.bankofapis.core.model.common.Constants;
import com.bankofapis.core.model.token.TokenRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TokenUtils {

    public HttpEntity<MultiValueMap<String, String>> createTokenObject(TokenRequest requestPayload) {
        List<MediaType> acceptTypes = new ArrayList<>();
        acceptTypes.add(MediaType.APPLICATION_JSON);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(acceptTypes);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add(Constants.CLIENT_ID_HEADER, requestPayload.getClientId());
        map.add(Constants.GRANT_TYPE_HEADER, requestPayload.getGrantType());

        if(!(StringUtils.isEmpty(requestPayload.getClientSecret())))
            map.add(Constants.CLIENT_SECRET_HEADER, requestPayload.getClientSecret());

        if(!(StringUtils.isEmpty(requestPayload.getRedirectUri())))
            map.add(Constants.REDIRECT_URI_HEADER, requestPayload.getRedirectUri());

        if(!StringUtils.isEmpty(requestPayload.getCode()))
            map.add(Constants.CODE_HEADER, requestPayload.getCode());

        if(!(StringUtils.isEmpty(requestPayload.getScope())))
            map.add(Constants.SCOPE_HEADER, requestPayload.getScope());

        if (!StringUtils.isEmpty(requestPayload.getCodeVerifier())) {
            map.add(Constants.CODE_VERIFIER_HEADER, requestPayload.getCodeVerifier());
        }

        if (!StringUtils.isEmpty(requestPayload.getCodeChallengeMethod())) {
            map.add(Constants.CODE_CHALLENGE_METHOD_HEADER, requestPayload.getCodeChallengeMethod());
        }

        return new HttpEntity<>(map, headers);
    }
}