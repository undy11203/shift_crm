package com.example.crm.controllers;

import com.example.crm.payload.transaction.TransactionCreateRequest;
import com.example.crm.payload.transaction.TransactionResponse;
import com.example.crm.services.TransactionService;
import com.example.crm.validators.TransactionCreateValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionCreateValidators transactionCreateValidators;


    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable int id) {
        return new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK);
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsBySellerId(@PathVariable int id) {
        return new ResponseEntity<>(transactionService.getAllTransactionBySeller(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionCreateRequest transactionCreateRequest, BindingResult bindingResult){
        transactionCreateValidators.validate(transactionCreateRequest, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        return new ResponseEntity<>(transactionService.createNewTransaction(transactionCreateRequest), HttpStatus.OK);
    }


}
