package com.example.crm.models;

public enum PaymentType {
    CASH("CASH"),
    CARD("CARD"),
    TRANSFER("TRANSFER");

    private final String translation;

    PaymentType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
