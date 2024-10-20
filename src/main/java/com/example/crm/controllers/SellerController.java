package com.example.crm.controllers;

import com.example.crm.payload.seller.SellerCreateRequest;
import com.example.crm.payload.seller.SellerUpdateRequest;
import com.example.crm.payload.seller.SellersResponse;
import com.example.crm.payload.seller.WithLessAmountByPeriodRequest;
import com.example.crm.payload.seller.MostProductivityByPeriodRequest;
import com.example.crm.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellersResponse>> getAllSellers() {
        return new ResponseEntity<>(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellersResponse> getSellerById(@PathVariable("id") int id) {
        return new ResponseEntity<>(sellerService.getSellerById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SellersResponse> createSeller(@RequestBody SellerCreateRequest sellerCreateRequest) {
        return new ResponseEntity<>(sellerService.createSeller(sellerCreateRequest), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<SellersResponse> updateSeller(@PathVariable("id") int id, @RequestBody SellerUpdateRequest sellerUpdateRequest){
        return new ResponseEntity<>(sellerService.updateSeller(id, sellerUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SellersResponse> deleteSeller(@PathVariable("id") int id) {
        return new ResponseEntity<>(sellerService.deleteSeller(id), HttpStatus.OK);
    }

    @GetMapping("/mostProductivity")
    public ResponseEntity<SellersResponse> getMostProductivitySellerByPeriod(@RequestBody MostProductivityByPeriodRequest request) {
        return new ResponseEntity<>(sellerService.getMostProductivitySellerByPeriod(request), HttpStatus.OK);
    }

    @GetMapping("/withLessAmount")
    public ResponseEntity<List<SellersResponse>>  getSellersWithLessAmountByPeriod(@RequestBody WithLessAmountByPeriodRequest request) {
        return new ResponseEntity<>(sellerService.getSellersWithLessAmountByPeriod(request), HttpStatus.OK);
    }
}
