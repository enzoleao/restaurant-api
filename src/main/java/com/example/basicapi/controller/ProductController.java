package com.example.basicapi.controller;

import com.example.basicapi.dtos.products.CreateProductRequestDTO;
import com.example.basicapi.dtos.products.CreateProductResponseDTO;
import com.example.basicapi.entity.Product;
import com.example.basicapi.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private  final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {
        return productService.createProduct(createProductRequestDTO);
    }

}
