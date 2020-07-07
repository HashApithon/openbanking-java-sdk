package com.bankofapis.remote.service;

import com.bankofapis.remote.common.Endpoints;
import com.bankofapis.remote.util.PispUtils;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.core.model.payments.OBWriteDomestic;
import com.bankofapis.core.model.payments.OBWriteDomesticConsent;
import com.bankofapis.core.model.payments.OBWriteDomesticConsentResponse;
import com.bankofapis.core.model.payments.OBWriteDomesticResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class PispRemote {

    private static final Logger logger = LoggerFactory.getLogger(PispRemote.class);

    private RestTemplate sslRestTemplate;
    private PispUtils pispUtil;

    public PispRemote(RestTemplate sslRestTemplate, PispUtils pispUtil) {
        this.sslRestTemplate = sslRestTemplate;
        this.pispUtil = pispUtil;
    }

    public OBWriteDomesticConsentResponse createPaymentConsent(OBWriteDomesticConsent obWriteDomesticConsent2, HttpRequestHeader httpRequestHeader) {

        return sslRestTemplate.exchange(
                pispUtil.getUri(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT),
                HttpMethod.POST,
                pispUtil.createRequest(obWriteDomesticConsent2, httpRequestHeader),
                OBWriteDomesticConsentResponse.class).getBody();

    }

    public String createAuthorizeUri(String consentId) {
       return  pispUtil.createAuthorizeUrl(consentId);
    }

    public OBWriteDomesticResponse createDomesticPayment(OBWriteDomestic obWriteDomestic2, HttpRequestHeader httpRequestHeader) {

        return sslRestTemplate.exchange(
                pispUtil.getUri(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT),
                HttpMethod.POST,
                pispUtil.createRequest(obWriteDomestic2, httpRequestHeader),
                OBWriteDomesticResponse.class).getBody();

    }

    public OBWriteDomesticResponse getPaymentStatus(String paymentId,  HttpRequestHeader httpRequestHeader) {

        return  sslRestTemplate.exchange(
                pispUtil.getUri(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT),
                HttpMethod.GET,
                pispUtil.createRequest(null, httpRequestHeader),
                OBWriteDomesticResponse.class,
                paymentId).getBody();

    }
}