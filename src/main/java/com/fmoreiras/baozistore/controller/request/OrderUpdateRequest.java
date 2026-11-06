package com.fmoreiras.baozistore.controller.request;

import java.util.Optional;

public record OrderUpdateRequest(
        Optional<Long> productId,
        Optional<Long> customerId,
        Optional<Integer> quantity
) {
}
