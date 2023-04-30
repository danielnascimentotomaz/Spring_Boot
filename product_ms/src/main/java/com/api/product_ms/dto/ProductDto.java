package com.api.product_ms.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductDto {

    @NotBlank  // Notação da dependência validtion
    private String name;

    @Size(min = 50)// Notação da dependência validtion
    private  String description;

   @Positive// Notação da dependência validtion
    private double Price;


    private boolean available;
}
