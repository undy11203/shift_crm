package com.example.crm.payload.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellersResponse {
    private int id;

    private String name;

    private String contactInfo;

    private LocalDateTime registrationDate;
}
