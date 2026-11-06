package com.fmoreiras.baozistore.domain.model;

import com.fmoreiras.baozistore.controller.request.ProductUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Product update(ProductUpdateRequest updateRequest) {
        updateRequest.name().ifPresent(this::setName);
        updateRequest.price().ifPresent(this::setPrice);
        return this;
    }
}
