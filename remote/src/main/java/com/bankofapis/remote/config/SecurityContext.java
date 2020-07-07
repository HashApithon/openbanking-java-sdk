package com.bankofapis.remote.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class SecurityContext {

    @Autowired
    private SecurityConfig securityConfig;

    public RestTemplate securedRestTemplateWithMatls() throws IOException, KeyStoreException,
        CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

        KeyStore keyStore = KeyStore.getInstance(securityConfig.getKeyStoreType());
        keyStore.load(new FileInputStream(ResourceUtils.getFile(securityConfig.getKeyStoreLocation())),
            securityConfig.getKeyStorePassword().toCharArray());

        /*
         * Create an SSLContext that uses client.jks as the client certificate
         * and the truststore.jks as the trust material (trusted CA certificates).
         * In this sample, truststore.jks contains ca.pem which was used to sign
         * both client.pfx and server.jks.
         *
         * //, (map, socket) -> transportKeyStoreAlias
         */

        SSLContext sslContext = SSLContextBuilder.create()
                .loadKeyMaterial(keyStore, securityConfig.getKeyStorePassword().toCharArray())
                .loadTrustMaterial(ResourceUtils.getFile(securityConfig.getTrustStoreLocation()),
                    securityConfig.getTrustStorePassword().toCharArray())
                .build();

        /*
         * Create an HttpClient that uses the custom SSLContext
         */

        HttpClient client = HttpClientBuilder.create().useSystemProperties().setSSLContext(sslContext).build();

        /*
         * Create a RestTemplate that uses a request factory that references
         * our custom HttpClient
         */

        ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(client);
        return  new RestTemplate(clientHttpRequestFactory);

    }

     public RestTemplate securedRestTemplate() throws Exception{

        /*
         * Create a RestTemplate that uses a request factory that references
         * our custom HttpClient
         */

        /*
         * acceptingTrustStrategy to trust all certificate is not recommended,
         * use securedRestTemplateWithMatls(MATLS) in PROD
         *
         */
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom().useSystemProperties()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

    @Bean("securedRestTemplate")
    public RestTemplate getSecureRestTemplate() throws Exception{
        if(securityConfig.isEnableMatls()) {
            return securedRestTemplateWithMatls();
        }

        return securedRestTemplate();
    }
}