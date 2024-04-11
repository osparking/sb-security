package com.bumsoap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bumsoap.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
