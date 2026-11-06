package com.fmoreiras.baozistore.controller.request;

import com.fmoreiras.baozistore.domain.model.Product;

import java.math.BigDecimal;

public record ProductCreationRequest(
        String name,
        BigDecimal price
) {
    public static Product toDomain(ProductCreationRequest request) {
        return new Product(
                request.name,
                request.price
        );
    }
}
