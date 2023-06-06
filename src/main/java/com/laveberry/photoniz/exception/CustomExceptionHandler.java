package com.laveberry.photoniz.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ExceptionType exceptionType = e.getExceptionType();
        log.error("Exception Throw : {}", exceptionType);
        return ErrorResponse.toResponseEntity(exceptionType);
    }
}
