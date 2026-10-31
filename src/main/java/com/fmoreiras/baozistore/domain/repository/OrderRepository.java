package com.fmoreiras.baozistore.repository;

import com.fmoreiras.baozistore.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "orders")
public interface OrderRepository extends CrudRepository<Order, Long> {}
