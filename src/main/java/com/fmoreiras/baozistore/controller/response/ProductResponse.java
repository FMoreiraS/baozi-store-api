package com.fmoreiras.baozistore.controller.response;

import com.fmoreiras.baozistore.domain.model.Product;

public record ProductResponse(String id, String name, double price) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId().toString(),
                product.getName(),
                product.getPrice().doubleValue()
        );
    }
}
