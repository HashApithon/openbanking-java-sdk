package com.bankofapis.model;

import com.bankofapis.core.model.accounts.OBReadDataDomesticConsent;
import com.bankofapis.core.model.accounts.OBReadDomesticConsent;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.core.model.payments.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ApiMockModel {

    public static OBReadDomesticConsent buildAispConsentJsonPayload() {

        List<String> permission = new ArrayList<>();
        permission.addAll(Arrays.asList("ReadAccountsBasic", "ReadAccountsDetail", "ReadBalances",
                "ReadBeneficiariesBasic", "ReadBeneficiariesDetail", "ReadDirectDebits",
                "ReadProducts", "ReadStandingOrdersBasic", "ReadStandingOrdersDetail",
                "ReadTransactionsBasic", "ReadTransactionsCredits", "ReadTransactionsDebits",
                "ReadTransactionsDetail"));

        OBReadDataDomesticConsent obReadDataDomesticConsent = new OBReadDataDomesticConsent();
        obReadDataDomesticConsent.setPermissions(permission);
        OBReadDomesticConsent obReadDomesticConsent =  new OBReadDomesticConsent();
        obReadDomesticConsent.setData(obReadDataDomesticConsent);
        obReadDomesticConsent.setRisk(new OBRisk());
        return obReadDomesticConsent;
    }


    public static OBWriteDomesticConsent buildPispConsentJsonPayload() {
        // payment initiation data
        OBWriteDataDomesticConsent data = new OBWriteDataDomesticConsent().initiation(
                new OBDomestic()
                        .instructedAmount(
                                new OBDomesticInstructedAmount()
                                        .amount("120")
                                        .currency("EUR")
                        )
                        .creditorAccount(
                                new OBCashAccountCreditor()
                                        .schemeName("UK.OBIE.SortCodeAccountNumber")
                                        .identification("08080021325698")
                                        .name("Where the money goes")
                                        .secondaryIdentification("secondary id")
                        )
                        .instructionIdentification("instruction id")
                        .endToEndIdentification("e2e id")
        );


        // risk data
        OBRisk risk = new OBRisk().paymentContextCode(OBExternalPaymentContextCode.ECOMMERCEGOODS);

        // consent request
        return new OBWriteDomesticConsent().data(data).risk(risk);
    }

    public static HttpRequestHeader buildHeader(String token, String financialId, String jwsSignature) {
        HttpRequestHeader headers = new HttpRequestHeader();
        headers.setAuthorization("Bearer "+token);
        headers.setJwsSignature(jwsSignature);
        headers.setIdempotencyKey(UUID.randomUUID().toString());
        headers.setFinancialId(financialId);
        return headers;

    }

}