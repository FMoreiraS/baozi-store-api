package com.fmoreiras.baozistore.controller;

import com.fmoreiras.baozistore.controller.request.CustomerCreationRequest;
import com.fmoreiras.baozistore.controller.request.CustomerUpdateRequest;
import com.fmoreiras.baozistore.controller.response.CustomerResponse;
import com.fmoreiras.baozistore.domain.model.Customer;
import com.fmoreiras.baozistore.domain.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CustomerCreationRequest request) {
        Customer saved = repository.save(CustomerCreationRequest.toDomain(request));
        return CustomerResponse.from(saved);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> readAll() {
        return repository.findAll().stream().map(CustomerResponse::from).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse readOne(@PathVariable Long id) {
        return CustomerResponse.from(repository.findById(id).get());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable Long id, CustomerUpdateRequest request) {
        Customer toUpdate = repository.findById(id).get();
        Customer updated = repository.save(toUpdate.update(request));
        return CustomerResponse.from(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
