package com.bankofapis.web.service;

import com.bankofapis.core.model.payments.OBWriteDomestic;
import com.bankofapis.core.model.payments.OBWriteDomesticConsent;
import com.bankofapis.core.model.payments.OBWriteDomesticConsentResponse;
import com.bankofapis.core.model.payments.OBWriteDomesticResponse;
import com.bankofapis.remote.service.PispRemote;
import com.bankofapis.web.filter.HttpRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpStatusCodeException;


public class PispService {

    private static final Logger logger = LoggerFactory.getLogger(PispService.class);

    private PispRemote pispRemote;

    public PispService(PispRemote pispRemote) {
        this.pispRemote = pispRemote;
    }

    public OBWriteDomesticConsentResponse createPaymentConsent(OBWriteDomesticConsent obWriteDomesticConsent2) {
        return pispRemote.createPaymentConsent(obWriteDomesticConsent2, HttpRequestContext.get());
    }

    public String createAuthorizeUri(String consentId) {
        return pispRemote.createAuthorizeUri(consentId);
    }

    public OBWriteDomesticResponse createDomesticPayment(OBWriteDomestic obWriteDomestic2) {

        try {
            return pispRemote.createDomesticPayment(obWriteDomestic2, HttpRequestContext.get());
        } catch (HttpStatusCodeException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBWriteDomesticResponse getPaymentStatus(String paymentId) {
        try {

            return pispRemote.getPaymentStatus(paymentId, HttpRequestContext.get());

        } catch (HttpStatusCodeException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

}