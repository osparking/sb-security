package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.Accounts;
import com.bumsoap.repository.AccountsRepository;

@RestController
public class AccountController {

  @Autowired
  private AccountsRepository accountsRepository;

  @GetMapping("/myAccount")
  public List<Accounts> getAccountDetails(@RequestParam int custId) {
    return accountsRepository.findByCustomerId(custId);
  }
}
