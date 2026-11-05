package com.fmoreiras.baozistore.controller;

import com.fmoreiras.baozistore.controller.request.ProductRequest;
import com.fmoreiras.baozistore.controller.response.ProductResponse;
import com.fmoreiras.baozistore.domain.model.Product;
import com.fmoreiras.baozistore.domain.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest request) {
        Product saved = repository.save(ProductRequest.toDomain(request));
        return ProductResponse.from(saved);
    }

    @GetMapping
    public List<ProductResponse> readAll() {
        return repository.findAll().stream().map(ProductResponse::from).toList();
    }

    @GetMapping("/{id}")
    public Optional<ProductResponse> readOne(@PathVariable Long id) {
        return repository.findById(id).map(ProductResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
