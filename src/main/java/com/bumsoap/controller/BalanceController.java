package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.AccountTransactions;
import com.bumsoap.model.Customer;
import com.bumsoap.repository.AccountTransactionsRepository;
import com.bumsoap.repository.CustomerRepository;

@RestController
public class BalanceController {

  @Autowired
  private AccountTransactionsRepository transactionsRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/myBalance")
  public List<AccountTransactions> getBalanceDetails(
      @RequestParam String email) {
    List<Customer> customers = customerRepository.findByEmail(email);
    if (customers != null && !customers.isEmpty()) {
      List<AccountTransactions> accountTransactions = transactionsRepository
          .findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
      if (accountTransactions != null) {
        return accountTransactions;
      }
    }
    return null;
  }
}
