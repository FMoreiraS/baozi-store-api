package com.fmoreiras.baozistore.controller;

import com.fmoreiras.baozistore.controller.request.CustomerRequest;
import com.fmoreiras.baozistore.controller.response.CustomerResponse;
import com.fmoreiras.baozistore.domain.model.Customer;
import com.fmoreiras.baozistore.domain.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CustomerRequest request) {
        Customer saved = repository.save(CustomerRequest.toDomain(request));
        return CustomerResponse.from(saved);
    }

    @GetMapping
    public List<CustomerResponse> readAll() {
        return repository.findAll().stream().map(CustomerResponse::from).toList();
    }

    @GetMapping("/{id}")
    public Optional<CustomerResponse> readOne(@PathVariable Long id) {
        return repository.findById(id).map(CustomerResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
