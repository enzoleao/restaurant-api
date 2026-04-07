package com.example.basicapi.dtos.products;

import lombok.Getter;

@Getter
public class CreateProductResponseDTO {
    private String name;
    private String description;
    private Double price;
}
