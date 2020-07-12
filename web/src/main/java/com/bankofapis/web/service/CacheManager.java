package com.bankofapis.web.service;

import com.bankofapis.core.model.common.Session;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CacheManager {

    private volatile  static  LoadingCache sessionCache;

    public static LoadingCache buildCache() {

        CacheLoader<String, Session> loader = new CacheLoader<String, Session>() {
            @Override
            public Session load(String key) throws Exception {
                Session session = new Session();
                session.setSessionId(key);
                session.setIdempotencyKey(UUID.randomUUID().toString());
                return session;
            }
        };

        LoadingCache<String, Session> sessionCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .softValues()
                .concurrencyLevel(4)
                .build(loader);
        return sessionCache;
    }

    public static LoadingCache getSessionCache() {
        if(sessionCache == null) {
            synchronized (CacheManager.class) {
                if(sessionCache == null) {
                    sessionCache = buildCache();
                }
            }
        }
        return sessionCache;
    }
}
