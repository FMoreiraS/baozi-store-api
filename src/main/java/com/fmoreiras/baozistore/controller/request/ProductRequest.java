package com.fmoreiras.baozistore.controller.request;

import com.fmoreiras.baozistore.domain.model.Product;

import java.math.BigDecimal;

public record ProductRequest(String name, double price) {
    public static Product toDomain(ProductRequest request) {
        return new Product(
                request.name(),
                BigDecimal.valueOf(request.price())
        );
    }
}
