package com.fmoreiras.baozistore.domain.repository;

import com.fmoreiras.baozistore.domain.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "orders")
public interface OrderRepository extends CrudRepository<Order, Long> {
    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(Long id);
    void deleteById(Long id);
}
