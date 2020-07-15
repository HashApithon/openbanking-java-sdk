package com.bankofapis.web.controller;

import com.bankofapis.core.model.accounts.*;
import com.bankofapis.web.service.AispService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.bankofapis.core.model.common.Constants.CONSENT_ID_HEADER;
import static com.bankofapis.remote.common.Endpoints.*;

@RestController
@RequestMapping("/open-banking/*/aisp")
public class AispController {

    private AispService aispService;

    @Autowired
    public AispController(AispService aispService) {
        this.aispService = aispService;
    }

    @GetMapping(value = OB_JOURNEY_INIT)
    public String initialize(HttpServletResponse response) {
        return aispService.initialize();
    }

    @PostMapping(value = ACCOUNT_ACCESS_CONSENT_ENDPOINT)
    public OBReadDomesticConsentResponse aispConsentSetup(
        @RequestBody OBReadDomesticConsent obReadDataDomesticConsent) {
        return aispService.createAispConsent(obReadDataDomesticConsent);
    }

    @GetMapping(value = AUTHORIZATION_OAUTH2_ENDPOINT)
    public String aispConsentAuthUrl(HttpServletRequest request) {
        return aispService.createAuthorizeUri(request.getParameter(CONSENT_ID_HEADER));
    }

    @GetMapping(value = ACCOUNT_LIST_ENDPOINT)
    public OBReadDataResponse<OBReadAccountList> getAccounts() {
        return aispService.getAccountResponse();
    }

    @GetMapping(value = ACCOUNT_ID_ENDPOINT)
    public OBReadDataResponse<OBReadAccountList> getAccountById(
        @PathVariable(value = "accountId") String accountId) {
        return aispService.getAccountById(accountId);
    }

    @GetMapping(value = ACCOUNT_ID_BALANCES_ENDPOINT)
    public OBReadDataResponse<OBReadBalanceList> getBalance(
        @PathVariable(value = "accountId") String accountId) {
        return aispService.getBalanceById(accountId);
    }

    @GetMapping(value = ACCOUNT_ID_TRANSACTIONS_ENDPOINT)
    public OBReadDataResponse<OBReadTransactionList> getTransactions(
        @PathVariable(value = "accountId") String accountId) {
        return aispService.getTransactionsById(accountId);
    }

    @GetMapping(value = ACCOUNT_ID_BENEFICIARIES_ENDPOINT)
    public OBReadDataResponse<OBReadBeneficiaryList> getBeneficiaries(
        @PathVariable(value = "accountId") String accountId) {
        return aispService.getBeneficiariesById(accountId);
    }

    @GetMapping(value = ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT)
    public OBReadDataResponse<OBReadDirectDebitList> getDirectDebitsById(
        @PathVariable(value = "accountId") String accountId) {
        return aispService.getDirectDebitsById(accountId);
    }

    @GetMapping(value = ACCOUNT_ID_STANDING_ORDERS_ENDPOINT)
    public OBReadDataResponse<OBReadStandingOrderList> getStandingOrderById(
        @PathVariable(value = "accountId") String accountId) {
        return aispService.getStandingOrdersById(accountId);
    }

    @GetMapping(value = ACCOUNT_ID_PRODUCT_ENDPOINT)
    public OBReadDataResponse<OBReadProductList> getProductById(
        @PathVariable(value = "accountId") String accountId) {
        return aispService.getProductById(accountId);
    }
}