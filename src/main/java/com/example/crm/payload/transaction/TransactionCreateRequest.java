package com.example.crm.payload.transaction;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCreateRequest {
    @NotEmpty
    private long sellerId;

    @NotEmpty
    private int amount;

    @NotEmpty
    private String paymentType;
}
