package com.fmoreiras.baozistore.repository;

import com.fmoreiras.baozistore.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {}
