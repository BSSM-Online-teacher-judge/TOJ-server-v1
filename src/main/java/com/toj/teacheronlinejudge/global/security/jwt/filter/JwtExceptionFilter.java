package com.toj.teacheronlinejudge.global.security.jwt.filter;

import com.toj.teacheronlinejudge.global.error.ErrorResponse;
import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException e) {
            setErrorResponse(response, e);
        }
    }

    private void setErrorResponse(HttpServletResponse response, BusinessException e) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json; charset=UTF-8");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(e.getErrorCode().getStatus())
                .message(e.getMessage())
                .build();

        response.getWriter().write(errorResponse.convertToJson());
    }
}
