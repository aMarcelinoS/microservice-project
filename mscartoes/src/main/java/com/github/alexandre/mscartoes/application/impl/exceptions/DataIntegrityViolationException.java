package com.github.alexandre.mscartoes.application.impl.exceptions;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
