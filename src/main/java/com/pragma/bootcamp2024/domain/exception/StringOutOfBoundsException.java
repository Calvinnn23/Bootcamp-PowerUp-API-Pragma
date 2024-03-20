package com.pragma.bootcamp2024.domain.exception;

public class StringOutOfBoundsException extends RuntimeException {
    public StringOutOfBoundsException(String message) {
        super(message);
    }
}
