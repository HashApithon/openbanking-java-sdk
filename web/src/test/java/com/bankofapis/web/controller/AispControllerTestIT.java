package com.bankofapis.web.controller;


import com.bankofapis.core.model.accounts.OBReadDomesticConsentResponse;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.remote.util.AispUtils;
import com.bankofapis.model.ApiMockModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static com.bankofapis.remote.common.Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT;
import static com.bankofapis.remote.common.Endpoints.AUTHORIZATION_OAUTH2_ENDPOINT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AispControllerTestIT extends BaseControllerTestIT {

    @Autowired
    private AispUtils aispUtils;

    @Test
    public void aispConsentApiTest() throws Exception {

        TokenResponse tokenResponse = getBearerToken("accounts");

        MvcResult consentResult = performPost(aispBasePath + ACCOUNT_ACCESS_CONSENT_ENDPOINT
                , aispUtils.createRequest(ApiMockModel.buildAispConsentJsonPayload()
                        , ApiMockModel.buildHeader(tokenResponse.getAccessToken(),
                                clientConfig.getFinancialId()
                                , "ignored"))
        );


        Optional<OBReadDomesticConsentResponse> aispConsent = jsonToPojo(consentResult.getResponse().getContentAsString(), OBReadDomesticConsentResponse.class);
        String consentId = aispConsent.get().getData().getConsentId();

        String authUrl = this.mockMvc.perform(get(aispBasePath + AUTHORIZATION_OAUTH2_ENDPOINT)
                .param("request", consentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assert.assertTrue(authUrl.contains(consentId));


    }
}