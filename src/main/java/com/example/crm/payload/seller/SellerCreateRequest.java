package com.example.crm.payload.seller;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerCreateRequest {
    @NotEmpty
    private String name;

    @NotEmpty
    private String contactInfo;
}
