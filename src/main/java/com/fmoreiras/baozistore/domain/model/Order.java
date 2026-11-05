package com.fmoreiras.baozistore.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    public Order(Long productId, Long customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }
}
