package com.example.crm.validators;

import com.example.crm.payload.transaction.TransactionCreateRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TransactionCreateValidators implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TransactionCreateRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TransactionCreateRequest request = (TransactionCreateRequest) target;

        if (request.getPaymentType() != "CASH" || request.getPaymentType() != "CARD" || request.getPaymentType() != "TRANSFER") {
            errors.reject("invalid field", "it's not a CASH or CARD or TRANSFER");
        }
    }
}
