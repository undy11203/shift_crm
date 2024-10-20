package com.example.crm.payload.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private int id;

    private int sellerId;

    private int amount;

    private String paymentType;

    private LocalDateTime transactionDate;
}
