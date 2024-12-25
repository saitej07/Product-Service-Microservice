package com.saiteja.product_service_microservice.dto;

import java.math.BigDecimal;

public record ProductRequest(Long id, String name, String description, BigDecimal price) {

}
