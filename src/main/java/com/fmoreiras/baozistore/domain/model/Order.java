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
    @Column(nullable = false)
    private Integer quantity;

    public Order(Long customerId, Long productId, Integer quantity) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Order update(OrderUpdateRequest updateRequest) {
        updateRequest.customerId().ifPresent(this::setCustomerId);
        updateRequest.productId().ifPresent(this::setProductId);
        updateRequest.quantity().ifPresent(this::setQuantity);
        return this;
    }
}
