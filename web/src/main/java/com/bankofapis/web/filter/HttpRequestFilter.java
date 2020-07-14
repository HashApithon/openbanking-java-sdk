package com.bankofapis.web.filter;

import com.bankofapis.core.model.common.Constants;
import com.bankofapis.core.model.common.HttpRequestHeader;
import com.bankofapis.core.model.common.Session;
import com.bankofapis.web.service.AispService;
import com.bankofapis.web.service.CacheManager;
import com.google.common.cache.CacheLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.UUID;

import static com.bankofapis.core.model.common.Constants.SESSION_ID;

public class HttpRequestFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, FilterChain filterChain) {
        try
        {
            HttpRequestContext.set(parseHeader(httpServletRequest));
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        catch (Exception ex){
            logger.error("Error occurred while processing the request", ex);
        }
        finally {
            HttpRequestContext.clear();
        }
    }

    private HttpRequestHeader parseHeader(HttpServletRequest request) {
        HttpRequestHeader httpRequestHeader = new HttpRequestHeader();
        String sessionId = request.getHeader(SESSION_ID);
        if(sessionId == null) {
            sessionId = UUID.randomUUID().toString();
            logger.info("sessionId: {}",sessionId);
        }

        httpRequestHeader.setAuthorization(request.getHeader(Constants.AUTHORIZATION_HEADER));
        httpRequestHeader.setFinancialId(request.getHeader(Constants.FINANCIAL_ID_HEADER));
        httpRequestHeader.setSessionId(sessionId);

        if(!StringUtils.isEmpty(request.getHeader(Constants.JWS_SIGNATURE_HEADER)))
            httpRequestHeader.setJwsSignature(request.getHeader(Constants.JWS_SIGNATURE_HEADER));
        if(!StringUtils.isEmpty(request.getHeader(Constants.IDEMPOTENCY_KEY_HEADER)))
            httpRequestHeader.setIdempotencyKey(request.getHeader(Constants.IDEMPOTENCY_KEY_HEADER));

        CacheManager.getSessionCache().getUnchecked(sessionId);

        return httpRequestHeader;
    }
}