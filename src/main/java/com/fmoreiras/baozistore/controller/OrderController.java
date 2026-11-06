package com.fmoreiras.baozistore.controller;

import com.fmoreiras.baozistore.controller.request.OrderCreationRequest;
import com.fmoreiras.baozistore.controller.request.OrderUpdateRequest;
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
    public OrderResponse create(@RequestBody OrderCreationRequest request) {
        Order saved = repository.save(OrderCreationRequest.toDomain(request));
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse update(@PathVariable Long id, @RequestBody OrderUpdateRequest request) {
        Order toUpdate = repository.findById(id).get();
        Order updated = repository.save(toUpdate.update(request));
        return OrderResponse.from(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}