package com.bankofapis.remote.utils;

import com.bankofapis.core.model.accounts.*;
import com.bankofapis.core.model.common.Constants;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.core.model.payments.*;
import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

public class TestHelperUtil {
	
	public static OBReadDomesticConsentResponse getConsentResponse() {
		OBRisk risk = new OBRisk().paymentContextCode(OBExternalPaymentContextCode.ECOMMERCEGOODS);
		OBReadDomesticConsentResponse response = new OBReadDomesticConsentResponse();
		response.setRisk(risk);
		return response;
	}

	public static OBReadDomesticConsent getDomesticConsentModel() {
		OBRisk risk = new OBRisk().paymentContextCode(OBExternalPaymentContextCode.ECOMMERCEGOODS);
		OBReadDomesticConsent consent=new OBReadDomesticConsent();
		consent.setRisk(risk);
		return consent;
	}
	
	public static TokenResponse getTokenResponse() {
		TokenResponse token = new TokenResponse();
		token.setIdToken("tokenId");
		return token;
	}
	
	public static TokenRequest getTokenRequest() {
		TokenRequest token = new TokenRequest();
		token.setClientId("client_id");
		return token;
	}
	
	public static String getAuthorizeUrl() {
		return "authorizeUrl";
	}
	
	public static String getAccountId() {
		return "accountId";
	}
	
	public static String getPaymentId() {
		return "paymentId";
	}

	public static OBReadDataResponse<OBReadAccountList> getAccountList() {
		List<OBReadAccount> list = new ArrayList<>();
		OBReadAccount account = new OBReadAccount();
		account.setName("name");
		list.add(account);
		OBReadAccountInformation accountInfo = new OBReadAccountInformation();
		accountInfo.setAccountId("accountId");
		accountInfo.setAccount(list);
		List<OBReadAccountInformation> accountInfoList = new ArrayList<OBReadAccountInformation>();
		accountInfoList.add(accountInfo);
		OBReadAccountList obReadList = new OBReadAccountList();
		obReadList.setAccount(accountInfoList);
		OBReadDataResponse<OBReadAccountList> obList = new OBReadDataResponse<>();
		obList.setData(obReadList);
		return obList;
	}
	
	public static OBReadDataResponse<OBReadBalanceList> getBalance() {
		List<OBReadBalance> blList = new ArrayList<>();
		OBReadBalance balance = new OBReadBalance();
		balance.setAccountId("accountId");;
		blList.add(balance);
		OBReadBalanceList obReadList = new OBReadBalanceList();
		obReadList.setAccount(blList);
		OBReadDataResponse<OBReadBalanceList> obList = new OBReadDataResponse<>();
		obList.setData(obReadList);
		return obList;
	}
	
	public static OBReadDataResponse<OBReadTransactionList> getTransaction() {
		List<OBReadTransaction> txnList = new ArrayList<>();
		OBReadTransaction txn = new OBReadTransaction();
		txn.setAccountId("accountId");;
		txnList.add(txn);
		OBReadTransactionList obReadList = new OBReadTransactionList();
		obReadList.setTransactionList(txnList);
		OBReadDataResponse<OBReadTransactionList> obList = new OBReadDataResponse<>();
		obList.setData(obReadList);
		return obList;
	}
	
	public static OBReadDataResponse<OBReadDirectDebitList> getDebitList() {
		List<OBReadDirectDebit> debitList = new ArrayList<>();
		OBReadDirectDebit debit = new OBReadDirectDebit();
		debit.setAccountId("accountId");;
		debitList.add(debit);
		OBReadDirectDebitList obReadList = new OBReadDirectDebitList();
		obReadList.setDirectDebitList(debitList);
		OBReadDataResponse<OBReadDirectDebitList> obList = new OBReadDataResponse<>();
		obList.setData(obReadList);
		return obList;
	}
	
	public static OBReadDataResponse<OBReadStandingOrderList> getStandingOrderList() {
		List<OBReadStandingOrder> standingOrderList = new ArrayList<>();
		OBReadStandingOrder so = new OBReadStandingOrder();
		so.setAccountId("accountId");;
		standingOrderList.add(so);
		OBReadStandingOrderList obReadList = new OBReadStandingOrderList();
		obReadList.setStandingOrderList(standingOrderList);
		OBReadDataResponse<OBReadStandingOrderList> obList = new OBReadDataResponse<>();
		obList.setData(obReadList);
		return obList;
	}
	
	public static OBReadDataResponse<OBReadProductList> getProductList() {
		List<OBReadProduct> productList = new ArrayList<>();
		OBReadProduct product = new OBReadProduct();
		product.setAccountId("accountId");;
		productList.add(product);
		OBReadProductList obReadList = new OBReadProductList();
		obReadList.setProductList(productList);
		OBReadDataResponse<OBReadProductList> obList = new OBReadDataResponse<>();
		obList.setData(obReadList);
		return obList;
	}
	
	public static OBReadDataResponse<OBReadBeneficiaryList> getBeneficiaryList() {
		List<OBReadBeneficiary> benList = new ArrayList<>();
		OBReadBeneficiary beneficiary = new OBReadBeneficiary();
		beneficiary.setAccountId("accountId");;
		benList.add(beneficiary);
		OBReadBeneficiaryList obReadList = new OBReadBeneficiaryList();
		obReadList.setBeneficiaryList(benList);
		OBReadDataResponse<OBReadBeneficiaryList> obList = new OBReadDataResponse<>();
		obList.setData(obReadList);
		return obList;
	}
	
	public static OBWriteDomesticConsentResponse getConsent() {
		OBRisk risk = new OBRisk().paymentContextCode(OBExternalPaymentContextCode.ECOMMERCEGOODS);
		OBWriteDataDomesticConsentResponse data = new OBWriteDataDomesticConsentResponse();
		data.setConsentId("consentId");
		OBWriteDomesticConsentResponse response = new OBWriteDomesticConsentResponse();
		response.setRisk(risk);
		response.setData(data);
		return response;
	}
	
	public static OBWriteDomesticConsent consentRequest() {
		OBRisk risk = new OBRisk().paymentContextCode(OBExternalPaymentContextCode.ECOMMERCEGOODS);
		OBWriteDomesticConsent response = new OBWriteDomesticConsent();
		response.setRisk(risk);
		return response;
	}

	public static OBWriteDomesticResponse obDomesticResponse() {
		OBWriteDataDomesticResponse data = new OBWriteDataDomesticResponse();
		data.setConsentId("consentId");
		data.setStatus(OBTransactionIndividualStatusCode.ACCEPTEDSETTLEMENTCOMPLETED);
		OBWriteDomesticResponse response = new OBWriteDomesticResponse();
		response.setData(data);
		return response;
	}
	
	public static HttpRequestHeader getHttpHeader() {
		HttpRequestHeader httpHeader = new HttpRequestHeader();
		httpHeader.setFinancialId("financialId");
		return httpHeader;		
	}
	
	public static OBWriteDomestic domesticRequest() {
		OBRisk risk = new OBRisk().paymentContextCode(OBExternalPaymentContextCode.ECOMMERCEGOODS);
		OBWriteDomestic domesticConsent = new OBWriteDomestic();
		OBWriteDataDomestic data = new OBWriteDataDomestic();
		data.setConsentId("consentId");
		domesticConsent.setData(data);
		domesticConsent.setRisk(risk);
		return domesticConsent;
	}

	private static HttpEntity createHttpEntity(Object entity, HttpHeaders httpHeaders){
		return new HttpEntity<>(entity, httpHeaders);
	}

	public static HttpEntity createRequest(Object entity, HttpRequestHeader httpRequestHeader){
		HttpHeaders headers = createHeaders(httpRequestHeader);
		return createHttpEntity(entity, headers);
	}

	private static HttpHeaders createHeaders(HttpRequestHeader httpRequestHeader) {
		List<MediaType> acceptTypes = new ArrayList<>();
		HttpHeaders headers = new HttpHeaders();

		acceptTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceptTypes);
		headers.set(Constants.FINANCIAL_ID_HEADER, httpRequestHeader.getFinancialId());

		return headers;
	}
	
	 public static HttpEntity<MultiValueMap<String, String>> createTokenObject(TokenRequest requestPayload) {
		List<MediaType> acceptTypes = new ArrayList<>();
		acceptTypes.add(MediaType.APPLICATION_JSON);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(acceptTypes);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

		map.add(Constants.CLIENT_ID_HEADER, requestPayload.getClientId());
		map.add(Constants.GRANT_TYPE_HEADER, requestPayload.getGrantType());

		return new HttpEntity<>(map, headers);
	 }


}