package com.bankofapis.remote.service;

import com.bankofapis.remote.config.ClientConfig;
import com.bankofapis.remote.utils.TestHelperUtil;
import com.bankofapis.core.model.token.TokenRequest;
import com.bankofapis.core.model.token.TokenResponse;
import com.bankofapis.remote.util.TokenUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TokenRemoteTest {
	
	@Mock
    private RestTemplate restTemplate;
	@Mock
    private TokenUtils tokenUtil;
	@Mock
    private ClientConfig clientConfig;
	
	private
	TokenRemote tokenRemote;
	private TokenRequest tokenRequest;
	
	@Before
    public void setup() {
		tokenRemote = new TokenRemote(restTemplate, tokenUtil, clientConfig);
		tokenRequest= TestHelperUtil.getTokenRequest();
    }
	
	@Test
	public void testRestTemplateCallFromToken() {
		
		TokenResponse response = TestHelperUtil.getTokenResponse();
    	ResponseEntity<TokenResponse> responseEntity = new ResponseEntity<TokenResponse>(response, HttpStatus.OK);
		when(tokenUtil.createTokenObject(any(TokenRequest.class))).thenReturn(TestHelperUtil.createTokenObject(tokenRequest));
		when(clientConfig.getTokenUrl()).thenReturn("/tokenUrl");
    	when(restTemplate.postForEntity(Mockito.eq("/tokenUrl"), Mockito.eq(TestHelperUtil.createTokenObject(tokenRequest)), Mockito.<Class<TokenResponse>>any())).thenReturn(responseEntity);
    	tokenRemote.generateToken(TestHelperUtil.getTokenRequest());
		verify(restTemplate, times(1)).postForEntity(Mockito.eq("/tokenUrl"),
				Mockito.eq(TestHelperUtil.createTokenObject(tokenRequest)), Mockito.<Class<TokenResponse>>any());

}

	@SuppressWarnings("unchecked")
	@Test(expected = HttpStatusCodeException.class)
	public void testRestTemplateCallFromTokenWhenException() {
		
		when(tokenUtil.createTokenObject(any(TokenRequest.class))).thenReturn(TestHelperUtil.createTokenObject(tokenRequest));
		when(clientConfig.getTokenUrl()).thenReturn("/tokenUrl");
    	when(restTemplate.postForEntity(Mockito.eq("/tokenUrl"), Mockito.eq(TestHelperUtil.createTokenObject(tokenRequest)), Mockito.<Class<TokenResponse>>any())).thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
    	tokenRemote.generateToken(TestHelperUtil.getTokenRequest());
	}

}