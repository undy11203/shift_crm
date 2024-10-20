package com.example.crm.error.exception;

public class CrmException extends RuntimeException {
    protected String message;
    protected Long code;

    public CrmException(String message, Long id) {
        this.message = message;
        this.code = id;
    }

    public CrmException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public Long getId(){
        return code;
    }
}
