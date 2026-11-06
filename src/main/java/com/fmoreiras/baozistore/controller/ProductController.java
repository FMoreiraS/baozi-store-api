package com.fmoreiras.baozistore.controller;

import com.fmoreiras.baozistore.controller.request.ProductCreationRequest;
import com.fmoreiras.baozistore.controller.request.ProductUpdateRequest;
import com.fmoreiras.baozistore.controller.response.ProductResponse;
import com.fmoreiras.baozistore.domain.model.Product;
import com.fmoreiras.baozistore.domain.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductCreationRequest request) {
        Product saved = repository.save(ProductCreationRequest.toDomain(request));
        return ProductResponse.from(saved);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> readAll() {
        return repository.findAll().stream().map(ProductResponse::from).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse readOne(@PathVariable Long id) {
        return ProductResponse.from(repository.findById(id).get());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductUpdateRequest request) {
        Product toUpdate = repository.findById(id).get();
        Product updated = repository.save(toUpdate.update(request));
        return ProductResponse.from(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
