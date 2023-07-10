package com.laveberry.photoniz.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laveberry.photoniz.exception.ExceptionType;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommonWriter {

    private static String convertToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Could not convert object to JSON", e);
        }
    }

    public static void exceptionWriter(HttpServletResponse response, Exception exception) throws IOException {

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
