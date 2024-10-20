package com.example.crm.controllers;

import com.example.crm.payload.transaction.TransactionCreateRequest;
import com.example.crm.payload.transaction.TransactionResponse;
import com.example.crm.services.TransactionService;
import com.example.crm.validates.TransactionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    private final TransactionValidator transactionValidator;

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getTransactions() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable int id) {

    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsBySellerId(@PathVariable int id) {

    }

    @PostMapping("/create")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionCreateRequest transactionCreateRequest){

    }


}
