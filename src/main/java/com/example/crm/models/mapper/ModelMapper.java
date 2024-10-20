package com.example.crm.models.mapper;

import com.example.crm.models.Seller;
import com.example.crm.models.Transaction;
import com.example.crm.payload.seller.SellerCreateRequest;
import com.example.crm.payload.seller.SellerUpdateRequest;
import com.example.crm.payload.seller.SellersResponse;
import com.example.crm.payload.transaction.TransactionCreateRequest;
import com.example.crm.payload.transaction.TransactionResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ModelMapper {
    SellersResponse toSellerResponse(Seller seller);

    Seller toSeller(SellerCreateRequest sellerCreateRequest);

    void map(SellerUpdateRequest sellerUpdateRequest, @MappingTarget Seller seller);

    TransactionResponse toTransactionResponse(Transaction transaction);

    Transaction toTransaction(TransactionCreateRequest transactionCreateRequest);
}
