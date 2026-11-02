package com.fmoreiras.baozistore.controller.response;

import com.fmoreiras.baozistore.domain.model.Order;

public record OrderResponse(String orderId, String productId, String customerId) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId().toString(),
                order.getProductId().toString(),
                order.getCustomerId().toString()
        );
    }
}
