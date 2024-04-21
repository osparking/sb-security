package com.bumsoap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bumsoap.model.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
  Accounts findByCustomerId(int customerId);
}
