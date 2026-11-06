package com.fmoreiras.baozistore.controller.request;

import com.fmoreiras.baozistore.domain.model.Order;

public record OrderCreationRequest(
        Long customerId,
        Long productId
) {
    public static Order toDomain(OrderCreationRequest request) {
        return new Order(
                request.customerId,
                request.productId
        );
    }
}
