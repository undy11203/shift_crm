package com.example.crm.services.impl;

import com.example.crm.error.exception.AlreadyExsistException;
import com.example.crm.error.exception.NotFoundException;
import com.example.crm.models.Seller;
import com.example.crm.models.mapper.ModelMapper;
import com.example.crm.payload.seller.SellerCreateRequest;
import com.example.crm.payload.seller.SellerUpdateRequest;
import com.example.crm.payload.seller.SellersResponse;
import com.example.crm.repository.SellerRepository;
import com.example.crm.services.SellerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public List<SellersResponse> getAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream()
                .map(seller -> modelMapper.toSellerResponse(seller))
                .collect(Collectors.toList());
    }

    @Transactional
    public SellersResponse getSellerById(long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found when found by id", id));
        return modelMapper.toSellerResponse(seller);
    }

    @Transactional
    public SellersResponse createSeller(SellerCreateRequest sellerCreateRequest) {
        Seller seller = modelMapper.toSeller(sellerCreateRequest);
        seller.setRegistrationDate(LocalDateTime.now());
        try {
            seller = sellerRepository.save(seller);
            return modelMapper.toSellerResponse(seller);
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExsistException(e.getMessage());
        }

    }

    @Transactional
    public SellersResponse updateSeller(long id, SellerUpdateRequest sellerUpdateRequest) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found", id));
        modelMapper.map(sellerUpdateRequest, seller);
        return modelMapper.toSellerResponse(seller);
   }

   @Transactional
    public SellersResponse deleteSeller(long id) {
        SellersResponse sellersResponse;
        if(sellerRepository.existsById(id)){
            sellersResponse = modelMapper.toSellerResponse(sellerRepository.findById(id).orElse(null));
            sellerRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not found", id);
        }
        return sellersResponse;
    }
}
