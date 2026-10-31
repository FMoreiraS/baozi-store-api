package com.fmoreiras.baozistore.controller.response;

import com.fmoreiras.baozistore.domain.model.Customer;

import java.time.LocalDate;

public record CustomerResponse (String id, String name, LocalDate customerSince){
    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(
                customer.getId().toString(),
                customer.getName(),
                customer.getCustomerSince()
        );
    }
}
