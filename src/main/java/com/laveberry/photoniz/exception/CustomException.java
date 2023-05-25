package com.laveberry.photoniz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ExceptionType exceptionType;
}
