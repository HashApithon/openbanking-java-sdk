package com.bankofapis.remote.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RemoteContext.class)
public class RootContext {
}