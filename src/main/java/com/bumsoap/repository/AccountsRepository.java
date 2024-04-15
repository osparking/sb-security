package com.bumsoap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bumsoap.model.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
  List<Accounts> findByCustomerId(int customerId);
}
