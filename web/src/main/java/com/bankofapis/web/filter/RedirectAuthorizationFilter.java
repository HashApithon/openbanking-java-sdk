package com.bankofapis.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectAuthorizationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain) {
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            httpServletResponse.encodeRedirectURL(HttpRequestContext.get().getAuthorizationURL());
        } catch (Exception ex) {
            logger.error("Error occurred while processing the request");
        } finally {
            HttpRequestContext.clear();
        }
    }
}
