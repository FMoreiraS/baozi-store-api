package com.fmoreiras.baozistore.domain.model;

import com.fmoreiras.baozistore.controller.request.CustomerUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate customerSince;

    public Customer(String name, LocalDate customerSince) {
        this.name = name;
        this.customerSince = customerSince;
    }

    public Customer update(CustomerUpdateRequest updateRequest) {
        updateRequest.name().ifPresent(this::setName);
        updateRequest.customerSince().ifPresent(this::setCustomerSince);
        return this;
    }
}
