package com.fmoreiras.baozistore.controller.response;

import com.fmoreiras.baozistore.domain.model.Order;

public record OrderResponse(
        Long orderId,
        Long productId,
        Long customerId,
        Integer quantity
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProductId(),
                order.getCustomerId(),
                order.getQuantity()
        );
    }
}
