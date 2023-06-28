package com.laveberry.photoniz.config.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laveberry.photoniz.exception.ExceptionType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, AccessDeniedHandler {
    private String convertToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Could not convert object to JSON", e);
        }
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        exceptionWriter(response, authException);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        exceptionWriter(response, accessDeniedException);

    }

    private void exceptionWriter(HttpServletResponse response, Exception exception) throws IOException {

        final ExceptionType type;

        if (exception instanceof AuthenticationException) {
            type = ExceptionType.NOT_AUTHORIZED_TOKEN;
        } else if (exception instanceof AccessDeniedException){
            type = ExceptionType.ACCESS_DENIED;
        } else {
            type = ExceptionType.UNKNOWN_EXCEPTION_TYPE;
        }

        Map<String, Object> errorDetails = new HashMap<>();

        errorDetails.put("statusCode", type.getStatus().value());
        errorDetails.put("status", type.getStatus().name());
        errorDetails.put("errorCode", type.getErrorCode());
        errorDetails.put("message", type.getMessage());

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(convertToJson(errorDetails));
    }
}
