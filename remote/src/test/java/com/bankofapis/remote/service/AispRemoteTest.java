package com.bankofapis.remote.service;

import com.bankofapis.core.model.accounts.*;
import com.bankofapis.remote.common.Endpoints;
import com.bankofapis.remote.utils.TestHelperUtil;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.remote.util.BaseApiUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AispRemoteTest {
	
	@Mock
    private RestTemplate restTemplate;
	@Mock
    private BaseApiUtils apiUtils;
	
	private AispRemote aispRemote;
	
	private String accountId;
	
	@Before
    public void setup() {
		aispRemote = new AispRemote(restTemplate, apiUtils);
		accountId= TestHelperUtil.getAccountId();

    }

    @Test
    public void tesRestTemplateCallFromAispConsent() {
    	
		OBReadDomesticConsentResponse response = TestHelperUtil.getConsentResponse();
		ResponseEntity<OBReadDomesticConsentResponse> responseEntity = new ResponseEntity<OBReadDomesticConsentResponse>(
				response, HttpStatus.OK);
		when(apiUtils.createRequest(any(OBReadDomesticConsent.class), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(TestHelperUtil.getDomesticConsentModel(), TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT);
		when(restTemplate.postForEntity(Mockito.endsWith(Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT),
				Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.getDomesticConsentModel(),
						TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBReadDomesticConsentResponse>>any())).thenReturn(responseEntity);
		aispRemote.createAispConsent(TestHelperUtil.getDomesticConsentModel(), TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).postForEntity(
				Mockito.endsWith(Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT), Mockito.eq(TestHelperUtil
						.createRequest(TestHelperUtil.getDomesticConsentModel(), TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBReadDomesticConsentResponse>>any());
    }
    
	@Test(expected = HttpStatusCodeException.class)
    public void tesRestTemplateCallFromAispConsentWhenException() {
		
		when(apiUtils.createRequest(any(OBReadDomesticConsent.class), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(TestHelperUtil.getDomesticConsentModel(), TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT);
		when(restTemplate.postForEntity(Mockito.eq(Endpoints.ACCOUNT_ACCESS_CONSENT_ENDPOINT),
				Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.getDomesticConsentModel(),
						TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBReadDomesticConsentResponse>>any()))
						.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.createAispConsent(TestHelperUtil.getDomesticConsentModel(), TestHelperUtil.getHttpHeader());
	}
	
	@Test
	public void testRestTemplateCallFromAccounts() {

		OBReadDataResponse<OBReadAccountList> accountList = TestHelperUtil.getAccountList();
        ResponseEntity<OBReadDataResponse<OBReadAccountList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadAccountList>>(accountList, HttpStatus.OK);
        when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_LIST_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_LIST_ENDPOINT);
        when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_LIST_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>>any()))
						.thenReturn(responseEntity);   
        aispRemote.getAccountResponse(TestHelperUtil.getHttpHeader());
        verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_LIST_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>>any());
	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromAccountsWhenException() {
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_LIST_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_LIST_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_LIST_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>>any()))
				  		.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getAccountResponse(TestHelperUtil.getHttpHeader());
	}

	@Test
	public void testRestTemplateCallFromAccountById() {

		OBReadDataResponse<OBReadAccountList> accountList = TestHelperUtil.getAccountList();
		ResponseEntity<OBReadDataResponse<OBReadAccountList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadAccountList>>(accountList, HttpStatus.OK);
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>>any(), anyString()))
						.thenReturn(responseEntity);   
		aispRemote.getAccountById(accountId,TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>>any(), anyString());
	}
	
	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromAccountByIdWhenException() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_ENDPOINT), Mockito.<HttpMethod>eq(HttpMethod.GET),
				Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadAccountList>>>any(), anyString()))
						.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getAccountById(accountId, TestHelperUtil.getHttpHeader());
	}
	@Test
	public void testRestTemplateCallFromBalanceById() {

		OBReadDataResponse<OBReadBalanceList> balance = TestHelperUtil.getBalance();
		ResponseEntity<OBReadDataResponse<OBReadBalanceList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadBalanceList>>(balance, HttpStatus.OK);
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_BALANCES_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_BALANCES_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_BALANCES_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadBalanceList>>>any(), anyString()))
				.thenReturn(responseEntity);
		aispRemote.getBalanceById(accountId, TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_BALANCES_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadBalanceList>>>any(), anyString());

	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromBalanceByIdWhenException() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_BALANCES_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_BALANCES_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_BALANCES_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadBalanceList>>>any(), anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getBalanceById(accountId, TestHelperUtil.getHttpHeader());

	}

	@Test
	public void testRestTemplateCallFromTransactionById() {

		OBReadDataResponse<OBReadTransactionList> txn = TestHelperUtil.getTransaction();
		ResponseEntity<OBReadDataResponse<OBReadTransactionList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadTransactionList>>(txn, HttpStatus.OK);
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_TRANSACTIONS_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_TRANSACTIONS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_TRANSACTIONS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadTransactionList>>>any(), anyString()))
				.thenReturn(responseEntity);
		aispRemote.getTransactionsById(accountId, TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_TRANSACTIONS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadTransactionList>>>any(), anyString());
	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromTransactionByIdWhenException() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_TRANSACTIONS_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_TRANSACTIONS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_TRANSACTIONS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadTransactionList>>>any(), anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getTransactionsById(accountId, TestHelperUtil.getHttpHeader());
	}

	@Test
	public void testRestTemplateCallFromDirectDebitsById() {

		OBReadDataResponse<OBReadDirectDebitList> debit = TestHelperUtil.getDebitList();
		ResponseEntity<OBReadDataResponse<OBReadDirectDebitList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadDirectDebitList>>(debit, HttpStatus.OK);
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadDirectDebitList>>>any(), anyString()))
				.thenReturn(responseEntity);
		aispRemote.getDirectDebitsById(accountId, TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadDirectDebitList>>>any(), anyString());
	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromDirectDebitsByIdWhenException() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_DIRECT_DEBITS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadDirectDebitList>>>any(), anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getDirectDebitsById(accountId, TestHelperUtil.getHttpHeader());

	}

	@Test
	public void testRestTemplateCallFromStandingOrderById() {

		OBReadDataResponse<OBReadStandingOrderList> so = TestHelperUtil.getStandingOrderList();
		ResponseEntity<OBReadDataResponse<OBReadStandingOrderList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadStandingOrderList>>(so, HttpStatus.OK);
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadStandingOrderList>>>any(), anyString()))
				.thenReturn(responseEntity);
		aispRemote.getStandingOrdersById(accountId, TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadStandingOrderList>>>any(), anyString());
	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromStandingOrderByIdWhenException() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadStandingOrderList>>>any(), anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getStandingOrdersById(accountId, any());

	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromStandingOrderByIddWhenRequestIsInvalid() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_STANDING_ORDERS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadStandingOrderList>>>any(), anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		aispRemote.getStandingOrdersById(accountId, TestHelperUtil.getHttpHeader());
	}

	@Test
	public void testRestTemplateCallFromProductListById() {

		OBReadDataResponse<OBReadProductList> product = TestHelperUtil.getProductList();
		ResponseEntity<OBReadDataResponse<OBReadProductList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadProductList>>(product, HttpStatus.OK);
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_PRODUCT_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_PRODUCT_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_PRODUCT_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadProductList>>>any(), anyString()))
				.thenReturn(responseEntity);
		aispRemote.getProductById(accountId, TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_PRODUCT_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadProductList>>>any(), anyString());

	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromProductListByIdWhenException() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_PRODUCT_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_PRODUCT_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_PRODUCT_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadProductList>>>any(), anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getProductById(accountId, TestHelperUtil.getHttpHeader());

	}

	@Test
	public void testRestTemplateCallFromBeneficiaryListById() {

		OBReadDataResponse<OBReadBeneficiaryList> benf = TestHelperUtil.getBeneficiaryList();
		ResponseEntity<OBReadDataResponse<OBReadBeneficiaryList>> responseEntity = new ResponseEntity<OBReadDataResponse<OBReadBeneficiaryList>>(benf, HttpStatus.OK);
		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_BENEFICIARIES_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_BENEFICIARIES_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_BENEFICIARIES_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadBeneficiaryList>>>any(), anyString()))
				.thenReturn(responseEntity);
		aispRemote.getBeneficiariesById(accountId, TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_BENEFICIARIES_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadBeneficiaryList>>>any(), anyString());

	}

	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromBeneficiaryListByIdWhenException() {

		when(apiUtils.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(apiUtils.getUri(Endpoints.ACCOUNT_ID_BENEFICIARIES_ENDPOINT)).thenReturn(Endpoints.ACCOUNT_ID_BENEFICIARIES_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.ACCOUNT_ID_BENEFICIARIES_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET),  Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<ParameterizedTypeReference<OBReadDataResponse<OBReadBeneficiaryList>>>any(), anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		aispRemote.getBeneficiariesById(accountId, TestHelperUtil.getHttpHeader());

	}

	@Test
	public void testGetAuthorizeUrl() {
		when(apiUtils.createAuthorizeUrl("consentId")).thenReturn(TestHelperUtil.getAuthorizeUrl());
		String mockResponse=aispRemote.createAuthorizeUri("consentId");
		Assert.assertNotNull(mockResponse);
	}

}