package com.ms.service.catalog.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.ms.service.catalog.entity.Customer;
import com.ms.service.catalog.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

@Component
@EnableAutoConfiguration
public class AppConfig {

    private final CustomerRepository customerRepository;

    public AppConfig(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    

    @PostConstruct
    public void generateTestData() {
        this.customerRepository.save(new Customer("Bob", "bob@domain.com"));
        this.customerRepository.save(new Customer("Sarah", "sarah@domain.com"));
        this.customerRepository.save(new Customer("Chen", "chen@domain.com"));
        this.customerRepository.save(new Customer("Mike", "mike@domain.com"));
        this.customerRepository.save(new Customer("Jack", "jack@domain.com"));
    }


}
