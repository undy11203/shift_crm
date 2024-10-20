package com.example.crm.payload.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionResponse {
    private int id;

    private int sellerId;

    private int amount;

    private String paymentType;

    private LocalDateTime transactionDate;
}
