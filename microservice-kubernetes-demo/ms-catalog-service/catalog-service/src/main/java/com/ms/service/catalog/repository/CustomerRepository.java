package com.ms.service.catalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.service.catalog.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
