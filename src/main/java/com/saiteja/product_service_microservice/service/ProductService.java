package com.saiteja.product_service_microservice.service;

import com.saiteja.product_service_microservice.dto.ProductRequest;
import com.saiteja.product_service_microservice.model.Product;
import com.saiteja.product_service_microservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;




    public void createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        productRepository.save(product);
    }

    public Product getProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        return product;

    }
}
