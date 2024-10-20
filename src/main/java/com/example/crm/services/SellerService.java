package com.example.crm.services;

import com.example.crm.payload.seller.SellerCreateRequest;
import com.example.crm.payload.seller.SellerUpdateRequest;
import com.example.crm.payload.seller.SellersResponse;

import java.util.List;

public interface SellerService {
    List<SellersResponse> getAllSellers();

    SellersResponse getSellerById(long id);

    SellersResponse createSeller(SellerCreateRequest sellerCreateRequest);

    SellersResponse updateSeller(long id, SellerUpdateRequest sellerUpdateRequest);

    SellersResponse deleteSeller(long id);
}
