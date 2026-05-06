package com.ms.service.catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ms.service.catalog.entity.Customer;
import com.ms.service.catalog.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindingCustomerById_thenCorrect() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        Assertions.assertNotNull(customerRepository.findById(1L));
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        customerRepository.save(new Customer("Julie", "julie@domain.com"));
        Assertions.assertNotNull(customerRepository.findAll());
    }

    @Test
    public void whenSavingCustomer_thenCorrect() {
        customerRepository.save(new Customer("Bob", "bob@domain.com"));
        Customer result = customerRepository.findById(1L).orElseGet(() -> new Customer("john", "john@domain.com"));
        Assertions.assertEquals("Bob", result.getName());
    }
}
