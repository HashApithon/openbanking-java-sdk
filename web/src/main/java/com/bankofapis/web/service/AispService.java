package com.bankofapis.web.service;

import com.bankofapis.core.model.accounts.*;
import com.bankofapis.remote.service.AispRemote;
import com.bankofapis.web.filter.HttpRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

public class AispService {

    private static final Logger logger = LoggerFactory.getLogger(AispService.class);

    private AispRemote aispRemote;

    public AispService(AispRemote aispRemote) {
        this.aispRemote = aispRemote;
    }

    public OBReadDomesticConsentResponse createAispConsent(OBReadDomesticConsent obReadDataDomesticConsent) {

        try {
            return aispRemote.createAispConsent(obReadDataDomesticConsent, HttpRequestContext.get());

        } catch (HttpStatusCodeException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }

    }

    public String createAuthorizeUri(String consentId) {
        return aispRemote.createAuthorizeUri(consentId);
    }

    public OBReadDataResponse<OBReadAccountList> getAccountResponse() {

        try {
            return aispRemote.getAccountResponse(HttpRequestContext.get());

        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }

    }

    public OBReadDataResponse<OBReadAccountList> getAccountById(String accountId) {
        try {
            return aispRemote.getAccountById(accountId, HttpRequestContext.get());
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBReadDataResponse<OBReadBalanceList> getBalanceById(String accountId) {

        try {
            return aispRemote.getBalanceById(accountId, HttpRequestContext.get());
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBReadDataResponse<OBReadTransactionList> getTransactionsById(String accountId) {
        try {
            return aispRemote.getTransactionsById(accountId, HttpRequestContext.get());
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBReadDataResponse<OBReadDirectDebitList> getDirectDebitsById(String accountId) {
        try {
            return aispRemote.getDirectDebitsById(accountId, HttpRequestContext.get());
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBReadDataResponse<OBReadStandingOrderList> getStandingOrdersById(String accountId) {
        try {
            return aispRemote.getStandingOrdersById(accountId, HttpRequestContext.get());
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBReadDataResponse<OBReadProductList> getProductById(String accountId) {

        try {
            return aispRemote.getProductById(accountId, HttpRequestContext.get());
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }

    public OBReadDataResponse<OBReadBeneficiaryList> getBeneficiariesById(String accountId) {
        try {
            return aispRemote.getBeneficiariesById(accountId, HttpRequestContext.get());
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
    }


}