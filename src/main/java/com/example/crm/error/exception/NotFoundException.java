package com.example.crm.error.exception;

public class NotFoundException extends CrmException {

    public NotFoundException(String message, Long id) {
        super(message, id);
    }

}
