package com.example.basicapi.dtos.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String name;
    private String description;
    private Double price;
}
