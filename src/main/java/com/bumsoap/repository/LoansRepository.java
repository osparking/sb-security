package com.bumsoap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.bumsoap.model.Loans;

@Repository
public interface LoansRepository extends CrudRepository<Loans, Integer> {

  @PreAuthorize("hasRole('ROOT')")
  List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
