package com.bankofapis.remote.service;

import com.bankofapis.remote.common.Endpoints;
import com.bankofapis.remote.utils.TestHelperUtil;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.core.model.payments.OBWriteDomesticConsent;
import com.bankofapis.core.model.payments.OBWriteDomesticConsentResponse;
import com.bankofapis.core.model.payments.OBWriteDomesticResponse;
import com.bankofapis.remote.util.PispUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
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
public class PispRemoteTest {

	@Mock
	private RestTemplate restTemplate;
	@Mock
	private PispUtils pispUtil;
	
	private PispRemote pispRemote;
	private String paymentId;
	
	@Before
    public void setup() {
		pispRemote = new PispRemote(restTemplate, pispUtil);
		paymentId= TestHelperUtil.getPaymentId();
    }
	
	@Test
	public void testRestTemplateCallFromPaymentConsent() {

		OBWriteDomesticConsentResponse response = TestHelperUtil.getConsent();
		ResponseEntity<OBWriteDomesticConsentResponse> responseEntity = new ResponseEntity<OBWriteDomesticConsentResponse>(
				response, HttpStatus.OK);
		when(pispUtil.createRequest(any(OBWriteDomesticConsent.class), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader()));
		when(pispUtil.getUri(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT)).thenReturn(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.POST), Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticConsentResponse>>any()))
						.thenReturn(responseEntity);
		pispRemote.createPaymentConsent(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.POST), Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticConsentResponse>>any());
		
	}
	
	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromPaymentConsentWhenException() {

		when(pispUtil.createRequest(any(OBWriteDomesticConsent.class), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader()));
		when(pispUtil.getUri(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT)).thenReturn(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENT_CONSENTS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.POST), Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticConsentResponse>>any()))
						.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		pispRemote.createPaymentConsent(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader());
		
	}

	@Test
	public void testRestTemplateCallFromDomesticPayment() {

		OBWriteDomesticResponse response = TestHelperUtil.obDomesticResponse();
		ResponseEntity<OBWriteDomesticResponse> responseEntity = new ResponseEntity<OBWriteDomesticResponse>(
				response, HttpStatus.OK);
		when(pispUtil.createRequest(any(OBWriteDomesticConsent.class), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader()));
		when(pispUtil.getUri(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT)).thenReturn(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.POST), Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticResponse>>any()))
				.thenReturn(responseEntity);
		pispRemote.createDomesticPayment(TestHelperUtil.domesticRequest(), TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.POST), Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticResponse>>any());
		
	}
	
	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromDomesticPaymentWhenException() {

		when(pispUtil.createRequest(any(OBWriteDomesticConsent.class), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader()));
		when(pispUtil.getUri(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT)).thenReturn(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENTS_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.POST), Mockito.eq(TestHelperUtil.createRequest(TestHelperUtil.consentRequest(), TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticResponse>>any()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		pispRemote.createDomesticPayment(TestHelperUtil.domesticRequest(), TestHelperUtil.getHttpHeader());

	}
	
	@Test
	public void testRestTemplateCallFromPaymentStatus() {

		OBWriteDomesticResponse response = TestHelperUtil.obDomesticResponse();
		ResponseEntity<OBWriteDomesticResponse> responseEntity = new ResponseEntity<OBWriteDomesticResponse>(
				response, HttpStatus.OK);
		when(pispUtil.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(pispUtil.getUri(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT)).thenReturn(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticResponse>>any(), Mockito.eq(paymentId)))
				.thenReturn(responseEntity);
		pispRemote.getPaymentStatus(paymentId, TestHelperUtil.getHttpHeader());
		verify(restTemplate, times(1)).exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticResponse>>any(), anyString());
	}
	
	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromPaymentStatusWhenException() {

		when(pispUtil.createRequest(any(), any(HttpRequestHeader.class))).thenReturn(
				TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader()));
		when(pispUtil.getUri(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT)).thenReturn(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT);
		when(restTemplate.exchange(Mockito.endsWith(Endpoints.DOMESTIC_PAYMENTS_PAYMENT_ID_ENDPOINT),
				Mockito.<HttpMethod>eq(HttpMethod.GET), Mockito.eq(TestHelperUtil.createRequest(null, TestHelperUtil.getHttpHeader())),
				Mockito.<Class<OBWriteDomesticResponse>>any(), Mockito.eq(paymentId)))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		pispRemote.getPaymentStatus(paymentId, TestHelperUtil.getHttpHeader());

	}
	
	@Test
	public void testGetAuthorizeUrl() {
		when(pispUtil.createAuthorizeUrl("consentId")).thenReturn(TestHelperUtil.getAuthorizeUrl());
		String mockResponse=pispRemote.createAuthorizeUri("consentId");
		Assert.assertNotNull(mockResponse);
	}

}