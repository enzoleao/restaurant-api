package com.example.basicapi.services;

import com.example.basicapi.dtos.products.CreateProductRequestDTO;
import com.example.basicapi.dtos.products.CreateProductResponseDTO;
import com.example.basicapi.entity.Product;
import com.example.basicapi.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(CreateProductRequestDTO createProductRequestDTO) {
        Product product = new Product();
        product.setName(createProductRequestDTO.getName());
        product.setDescription(createProductRequestDTO.getDescription());
        product.setPrice(createProductRequestDTO.getPrice());
        return this.productRepository.save(product);
    }

}
