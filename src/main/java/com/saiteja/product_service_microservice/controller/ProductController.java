package com.saiteja.product_service_microservice.controller;

import com.saiteja.product_service_microservice.dto.ProductRequest;
import com.saiteja.product_service_microservice.model.Product;
import com.saiteja.product_service_microservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return "Product Created Successfully";

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }
}
