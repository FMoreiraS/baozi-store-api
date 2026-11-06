package com.fmoreiras.baozistore.controller.request;

import com.fmoreiras.baozistore.domain.model.Customer;

import java.time.LocalDate;
import java.util.Optional;

public record CustomerCreationRequest(
        String name,
        Optional<LocalDate> customerSince
) {
    public static Customer toDomain(CustomerCreationRequest request) {
        return new Customer(
                request.name,
                request.customerSince.orElse(LocalDate.now())
        );
    }
}
