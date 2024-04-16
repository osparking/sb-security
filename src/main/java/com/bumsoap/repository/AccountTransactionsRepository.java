package com.bumsoap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bumsoap.model.AccountTransactions;

@Repository
public interface AccountTransactionsRepository
    extends CrudRepository<AccountTransactions, String> {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(
      int customerId);

}
