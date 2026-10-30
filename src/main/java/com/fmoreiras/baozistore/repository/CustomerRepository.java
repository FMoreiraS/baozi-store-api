package com.fmoreiras.baozistore.repository;

import com.fmoreiras.baozistore.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
