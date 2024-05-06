package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.Customer;
import com.bumsoap.model.Loans;
import com.bumsoap.repository.CustomerRepository;
import com.bumsoap.repository.LoansRepository;

@RestController
public class LoansController {
  @Autowired
  private LoansRepository loanRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/myLoans")
  public List<Loans> getLoanDetails(@RequestParam String email) {
    List<Customer> customers = customerRepository.findByEmail(email);
    if (customers != null && !customers.isEmpty()) {
      List<Loans> loans = loanRepository
          .findByCustomerIdOrderByStartDtDesc(customers.get(0).getId());
      if (loans != null) {
        return loans;
      }
    }
    return null;
  }
}
