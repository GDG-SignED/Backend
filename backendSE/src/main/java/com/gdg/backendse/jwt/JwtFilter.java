package com.gdg.backendse.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    private final TokenProvider tokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        // "/api/auth/google" 요청은 JWT 인증 없이 통과
        if (requestURI.startsWith("/api/auth/google")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = tokenProvider.resolveToken(httpRequest);

        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            // 로그 추가: JWT가 없거나 검증 실패하면 로그 남기기
            System.out.println(" JWT 검증 실패! 요청 URL: " + requestURI);
        }

        filterChain.doFilter(request, response);
    }

}
