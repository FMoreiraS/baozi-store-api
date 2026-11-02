package com.fmoreiras.baozistore.controller.request;

import com.fmoreiras.baozistore.domain.model.Order;

public record OrderRequest(String customerId, String productId) {
    public static Order toDomain(OrderRequest request) {
        return new Order(
                Long.parseLong(request.customerId),
                Long.parseLong(request.productId));
    }
}
