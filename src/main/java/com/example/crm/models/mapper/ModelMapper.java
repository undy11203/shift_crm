package com.example.crm.models.mapper;

import com.example.crm.models.Seller;
import com.example.crm.payload.seller.SellerCreateRequest;
import com.example.crm.payload.seller.SellerUpdateRequest;
import com.example.crm.payload.seller.SellersResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ModelMapper {
    SellersResponse toSellerResponse(Seller seller);

    Seller toSeller(SellerCreateRequest sellerCreateRequest);

    void map(SellerUpdateRequest sellerUpdateRequest, @MappingTarget Seller seller);
}
