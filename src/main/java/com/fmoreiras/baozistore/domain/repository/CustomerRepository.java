package com.fmoreiras.baozistore.domain.repository;

import com.fmoreiras.baozistore.domain.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    void deleteById(Long id);
}
