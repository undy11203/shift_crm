package com.example.crm.services;

import com.example.crm.payload.transaction.TransactionCreateRequest;
import com.example.crm.payload.transaction.TransactionResponse;

import java.util.List;

public interface TransactionService {
    List<TransactionResponse> getAllTransactions();

    TransactionResponse getTransactionById(long id);

    List<TransactionResponse> getAllTransactionBySeller(long id);

    TransactionResponse createNewTransaction(TransactionCreateRequest transactionCreateRequest);
}
