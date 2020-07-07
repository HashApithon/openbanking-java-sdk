package com.bankofapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestClientApplication {

    public static void main(String[] args) {

        /**
         * See {@link SingleImmediatePaymentConsent#applicationLaunch()}
         */
        ConfigurableApplicationContext ctx = SpringApplication.run(RestClientApplication.class, args);

    }

}