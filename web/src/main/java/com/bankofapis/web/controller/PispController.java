package com.bankofapis.web.controller;

import com.bankofapis.core.model.payments.OBWriteDomestic;
import com.bankofapis.core.model.payments.OBWriteDomesticConsent;
import com.bankofapis.core.model.payments.OBWriteDomesticConsentResponse;
import com.bankofapis.core.model.payments.OBWriteDomesticResponse;
import com.bankofapis.web.service.PispService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.bankofapis.core.model.common.Constants.CONSENT_ID_HEADER;
import static com.bankofapis.remote.common.Endpoints.*;

@RestController
@RequestMapping("/open-banking/*/pisp")
public class PispController {

    private PispService pispService;

    @Autowired
    public PispController(PispService pispService) {
        this.pispService = pispService;
    }

    @PostMapping(value = DOMESTIC_PAYMENT_CONSENTS_ENDPOINT)
    public ResponseEntity<OBWriteDomesticConsentResponse> paymentConsentSetup(@RequestBody OBWriteDomesticConsent obWriteDomesticConsent2) {
        OBWriteDomesticConsentResponse obWriteDataDomesticConsentResponse2 = pispService.createPaymentConsent(obWriteDomesticConsent2);
        return new ResponseEntity<>(obWriteDataDomesticConsentResponse2, HttpStatus.CREATED);
    }

    @GetMapping(value = AUTHORIZATION_OAUTH2_ENDPOINT)
    public String pispConsentAuthUrl(HttpServletRequest request) {
        return pispService.createAuthorizeUri(request.getParameter(CONSENT_ID_HEADER));
    }

    @PostMapping(value = DOMESTIC_PAYMENTS_ENDPOINT)
    public ResponseEntity<OBWriteDomesticResponse> submitPayments(@RequestBody OBWriteDomestic obWriteDomestic2) {
        OBWriteDomesticResponse paymentsSubmit = pispService.createDomesticPayment(obWriteDomestic2);
        return new ResponseEntity<>(paymentsSubmit, HttpStatus.CREATED);
    }

    @GetMapping(value = DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT)
    public OBWriteDomesticResponse getPaymentStatus(@PathVariable(value = "paymentId") String paymentId) {
        return pispService.getPaymentStatus(paymentId);
    }
}