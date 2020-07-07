package com.bankofapis.web.controller;

import com.bankofapis.core.model.payments.OBWriteDomesticConsentResponse;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.model.ApiMockModel;
import com.bankofapis.remote.util.PispUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static com.bankofapis.remote.common.Endpoints.AUTHORIZATION_OAUTH2_ENDPOINT;
import static com.bankofapis.remote.common.Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PispControllerTestIT extends BaseControllerTestIT {

    @Autowired
    private PispUtils pispUtils;

    @Test
    public void pispConsentApiTest() throws Exception {

        TokenResponse tokenResponse = getBearerToken("payments");

        MvcResult consentResult = performPost(pispBasePath + DOMESTIC_PAYMENT_CONSENTS_ENDPOINT
                , pispUtils.createRequest(ApiMockModel.buildPispConsentJsonPayload(), ApiMockModel.buildHeader(tokenResponse.getAccessToken(), clientConfig.getFinancialId(), "DUMMY_SIG")));


        Optional<OBWriteDomesticConsentResponse> pispConsent = jsonToPojo(consentResult.getResponse().getContentAsString(), OBWriteDomesticConsentResponse.class);
        String consentId = pispConsent.get().getData().getConsentId();

        String authUrl = this.mockMvc.perform(get(pispBasePath + AUTHORIZATION_OAUTH2_ENDPOINT)
                .param("request", consentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assert.assertTrue(authUrl.contains(consentId));


    }
}