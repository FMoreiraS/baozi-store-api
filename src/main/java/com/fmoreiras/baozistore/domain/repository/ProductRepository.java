package com.fmoreiras.baozistore.repository;

import com.fmoreiras.baozistore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void delete(Long id);
}
