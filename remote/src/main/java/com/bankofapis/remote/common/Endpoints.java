package com.bankofapis.remote.common;

public class Endpoints {

    public static final String AUTHORIZATION_OAUTH2_ENDPOINT = "/authorization.oauth2";
    public static final String OB_JOURNEY_INIT = "/init";

    public static final String ACCOUNT_ACCESS_CONSENT_ENDPOINT = "/account-access-consents";
    public static final String ACCOUNT_LIST_ENDPOINT = "/accounts";
    public static final String ACCOUNT_ID_ENDPOINT = "/accounts/{accountId}";
    public static final String ACCOUNT_ID_BALANCES_ENDPOINT = "/accounts/{accountId}/balances";
    public static final String ACCOUNT_ID_TRANSACTIONS_ENDPOINT = "/accounts/{accountId}/transactions";
    public static final String ACCOUNT_ID_BENEFICIARIES_ENDPOINT = "/accounts/{accountId}/beneficiaries";
    public static final String ACCOUNT_ID_STANDING_ORDERS_ENDPOINT = "/accounts/{accountId}/standing-orders";
    public static final String ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT = "/accounts/{accountId}/direct-debits";
    public static final String ACCOUNT_ID_PRODUCT_ENDPOINT = "/accounts/{accountId}/product";

    public static final String DOMESTIC_PAYMENT_CONSENTS_ENDPOINT = "/domestic-payment-consents";
    public static final String DOMESTIC_PAYMENTS_ENDPOINT = "/domestic-payments";
    public static final String DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT = "/domestic-payments/{paymentId}";
}