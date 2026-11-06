package com.fmoreiras.baozistore.domain.model;

import com.fmoreiras.baozistore.controller.request.OrderUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    @Column(name = "product_id", nullable = false)
    private Long productId;

    public Order(Long customerId, Long productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public Order update(OrderUpdateRequest updateRequest) {
        updateRequest.customerId().ifPresent(this::setCustomerId);
        updateRequest.productId().ifPresent(this::setProductId);
        return this;
    }
}
