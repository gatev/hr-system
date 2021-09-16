package com.hrsystem.usermanagement.exceptions;

public class ServiceApiException extends RuntimeException {
    public ServiceApiException(String exception) {
        super(exception);
    }
}
