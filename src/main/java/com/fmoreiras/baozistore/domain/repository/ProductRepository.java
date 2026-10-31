package com.fmoreiras.baozistore.domain.repository;

import com.fmoreiras.baozistore.domain.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void delete(Long id);
}
