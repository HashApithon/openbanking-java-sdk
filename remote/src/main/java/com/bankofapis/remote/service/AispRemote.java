package com.bankofapis.remote.service;

import com.bankofapis.core.model.accounts.*;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.remote.util.BaseApiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static com.bankofapis.remote.common.Endpoints.*;

public class AispRemote {

    private static final Logger logger = LoggerFactory.getLogger(AispRemote.class);

    private final RestTemplate securedRestTemplate;
    private final BaseApiUtils apiUtils;


    public AispRemote(RestTemplate securedRestTemplate, BaseApiUtils apiUtils) {
        this.securedRestTemplate = securedRestTemplate;
        this.apiUtils = apiUtils;
    }

    public OBReadDomesticConsentResponse createAispConsent(OBReadDomesticConsent obReadDataDomesticConsent, HttpRequestHeader httpRequestHeader) {

        HttpEntity<OBReadDomesticConsent> accountConsentRequest =
                apiUtils.createRequest(obReadDataDomesticConsent, httpRequestHeader);

       return securedRestTemplate.postForEntity(apiUtils.getUri(ACCOUNT_ACCESS_CONSENT_ENDPOINT),
                        accountConsentRequest, OBReadDomesticConsentResponse.class).getBody();

    }

    public String createAuthorizeUri(String consentId) {
        return apiUtils.createAuthorizeUrl(consentId);
    }

    public OBReadDataResponse<OBReadAccountList> getAccountResponse(HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_LIST_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>() {
                }).getBody();

    }

    public OBReadDataResponse<OBReadAccountList> getAccountById(String accountId, HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_ID_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>() {
                }, accountId).getBody();

    }

    public OBReadDataResponse<OBReadBalanceList> getBalanceById(String accountId, HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_ID_BALANCES_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadBalanceList>>() {
                }, accountId).getBody();
    }

    public OBReadDataResponse<OBReadTransactionList> getTransactionsById(String accountId, HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_ID_TRANSACTIONS_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadTransactionList>>() {
                }, accountId).getBody();
    }

    public OBReadDataResponse<OBReadDirectDebitList> getDirectDebitsById(String accountId, HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadDirectDebitList>>() {
                }, accountId).getBody();

    }

    public OBReadDataResponse<OBReadStandingOrderList> getStandingOrdersById(String accountId, HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_ID_STANDING_ORDERS_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadStandingOrderList>>() {
                }, accountId).getBody();

    }

    public OBReadDataResponse<OBReadProductList> getProductById(String accountId, HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_ID_PRODUCT_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadProductList>>() {
                }, accountId).getBody();

    }

    public OBReadDataResponse<OBReadBeneficiaryList> getBeneficiariesById(String accountId, HttpRequestHeader httpRequestHeader) {

        return securedRestTemplate.exchange(
                apiUtils.getUri(ACCOUNT_ID_BENEFICIARIES_ENDPOINT),
                HttpMethod.GET,
                apiUtils.createRequest(null, httpRequestHeader),
                new ParameterizedTypeReference<OBReadDataResponse<OBReadBeneficiaryList>>() {
                }, accountId).getBody();

    }
}