package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.AccountTransactions;
import com.bumsoap.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {

  @Autowired
  private AccountTransactionsRepository transactionsRepository;

  @GetMapping("/myBalance")
  public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
    return transactionsRepository
        .findByCustomerIdOrderByTransactionDtDesc(id);
  }
}
