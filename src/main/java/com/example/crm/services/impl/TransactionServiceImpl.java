package com.example.crm.services.impl;

import com.example.crm.error.exception.NotFoundException;
import com.example.crm.models.Seller;
import com.example.crm.models.Transaction;
import com.example.crm.models.mapper.ModelMapper;
import com.example.crm.payload.transaction.TransactionCreateRequest;
import com.example.crm.payload.transaction.TransactionResponse;
import com.example.crm.dao.repository.SellerRepository;
import com.example.crm.dao.repository.TransactionRepository;
import com.example.crm.services.TransactionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final SellerRepository sellerRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public List<TransactionResponse> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transaction ->  {
                    TransactionResponse response = modelMapper.toTransactionResponse(transaction);
                    response.setSellerId(transaction.getSeller().getId());
                    return response;
                }).collect(Collectors.toList());
    }

    @Transactional
    public TransactionResponse getTransactionById(long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found transaction", id));

        TransactionResponse response = modelMapper.toTransactionResponse(transaction);
        response.setSellerId(transaction.getSeller().getId());
        return response;
    }

    @Transactional
    public List<TransactionResponse> getAllTransactionBySeller(long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found seller", id));

        List<Transaction> transactions = seller.getTransactions();
        return transactions.stream()
                .map(transaction -> {
                    TransactionResponse response = modelMapper.toTransactionResponse(transaction);
                    response.setSellerId(transaction.getSeller().getId());
                    return response;
                }).collect(Collectors.toList());
    }

    @Transactional
    public TransactionResponse createNewTransaction(TransactionCreateRequest transactionCreateRequest) {
        Seller seller = sellerRepository.findById(transactionCreateRequest.getSellerId())
                .orElseThrow(() -> new NotFoundException("not found seller", transactionCreateRequest.getSellerId()));

        Transaction transaction = modelMapper.toTransaction(transactionCreateRequest);
        transaction.setSeller(seller);
        transaction.setTransactionDate(LocalDateTime.now());

        Transaction saveTransaction = transactionRepository.save(transaction);
        return modelMapper.toTransactionResponse(saveTransaction);
    }
}
