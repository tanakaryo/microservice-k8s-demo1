package com.ms.service.catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.service.catalog.entity.Customer;
import com.ms.service.catalog.repository.CustomerRepository;

@RestController
public class AppController {

    private final CustomerRepository customerRepository;

    public AppController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public Iterable<Customer> index() {
        return customerRepository.findAll();
    } 
}
