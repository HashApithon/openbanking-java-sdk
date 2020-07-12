package com.bankofapis.web.service;

import com.bankofapis.core.model.accounts.*;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.core.model.payments.OBRisk;
import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.remote.config.ClientConfig;
import com.bankofapis.remote.service.AispRemote;
import com.bankofapis.remote.service.TokenRemote;
import com.bankofapis.web.filter.HttpRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Arrays;

import static com.bankofapis.core.model.common.Constants.CLIENT_CRED_GRANT_TYPE_VALUE;
import static com.bankofapis.core.model.common.Constants.SCOPE_ACCOUNT_VALUE;

public class AispService {

    private static final Logger logger = LoggerFactory.getLogger(AispService.class);

    private AispRemote aispRemote;
    private TokenRemote tokenRemote;
    private ClientConfig clientConfig;

    public AispService(AispRemote aispRemote, TokenRemote tokenRemote, ClientConfig clientConfig) {
        this.aispRemote = aispRemote;
        this.tokenRemote = tokenRemote;
        this.clientConfig = clientConfig;
    }

    public String initialize() {
        try {

            if(Boolean.FALSE.equals(clientConfig.isInitRunning())) {
                throw new RuntimeException("SDK is not running in INIT mode");
            }

            TokenRequest tokenRequest = new TokenRequest();
            tokenRequest.setClientId(clientConfig.getClientId());
            tokenRequest.setClientSecret(clientConfig.getClientSecret());
            tokenRequest.setScope(SCOPE_ACCOUNT_VALUE);
            tokenRequest.setGrantType(CLIENT_CRED_GRANT_TYPE_VALUE);
            TokenResponse tokenResponse = tokenRemote.generateToken(tokenRequest);

            HttpRequestHeader httpRequestHeader = HttpRequestContext.get();
            httpRequestHeader.setAuthorization(tokenResponse.getTokenType()+" "+tokenResponse.getAccessToken());
            httpRequestHeader.setFinancialId(clientConfig.getFinancialId());
            HttpRequestContext.set(httpRequestHeader);

            String[] aispPermissions = new String[]{"ReadAccountsBasic", "ReadAccountsDetail", "ReadBalances",
                    "ReadBeneficiariesBasic", "ReadBeneficiariesDetail", "ReadDirectDebits",
                    "ReadProducts", "ReadStandingOrdersBasic", "ReadStandingOrdersDetail",
                    "ReadTransactionsBasic", "ReadTransactionsCredits", "ReadTransactionsDebits",
                    "ReadTransactionsDetail"};

            OBReadDomesticConsent obReadDataDomesticConsent = new OBReadDomesticConsent();
            obReadDataDomesticConsent.setData(new OBReadDataDomesticConsent());
            obReadDataDomesticConsent.setRisk(new OBRisk());

            obReadDataDomesticConsent.getData().setPermissions(Arrays.asList(aispPermissions));
            OBReadDomesticConsentResponse obReadDomesticConsentResponse =
                    aispRemote.createAispConsent(obReadDataDomesticConsent, HttpRequestContext.get());

            return  createAuthorizeUri(obReadDomesticConsentResponse.getData().getConsentId());
        } catch (HttpStatusCodeException ex) {
            logger.error(ex.getResponseBodyAsString(), ex);
            throw ex;
        }
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