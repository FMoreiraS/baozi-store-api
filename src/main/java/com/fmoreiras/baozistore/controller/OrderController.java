package com.fmoreiras.baozistore.controller;

import com.fmoreiras.baozistore.controller.request.OrderRequest;
import com.fmoreiras.baozistore.controller.response.OrderResponse;
import com.fmoreiras.baozistore.domain.model.Order;
import com.fmoreiras.baozistore.domain.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@RequestBody OrderRequest request) {
        Order saved = repository.save(OrderRequest.toDomain(request));
        return OrderResponse.from(saved);
    }

    @GetMapping
    public List<OrderResponse> readAll() {
        return repository.findAll().stream().map(OrderResponse::from).toList();
    }

    @GetMapping("/{id}")
    public Optional<OrderResponse> readOne(@PathVariable Long id) {
        return repository.findById(id).map(OrderResponse::from);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.delete(id);
    }

}