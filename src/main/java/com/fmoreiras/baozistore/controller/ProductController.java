package com.fmoreiras.baozistore.controller;

import com.fmoreiras.baozistore.model.Product;
import com.fmoreiras.baozistore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    public ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest request) {
        Product saved = service.save(ProductRequest.toDomain(request));
        return ProductResponse.from(saved);
    }

    @GetMapping
    public List<ProductResponse> readAll() {
        return service.getAll().stream().map(ProductResponse::from).toList();
    }

    @GetMapping("/{id}")
    public Optional<Product> readOne(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    public record ProductRequest(String name, double price) {
        public static Product toDomain(ProductRequest request) {
            return new Product(
                    request.name(),
                    BigDecimal.valueOf(request.price()
                    )
            );
        }
    }
    public record ProductResponse(String id, String name, double price) {
        static ProductResponse from(Product product) {
            return new ProductResponse(
                    product.getId().toString(),
                    product.getName(),
                    product.getPrice().doubleValue()
            );
        }
    }
}
