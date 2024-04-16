package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.Loans;
import com.bumsoap.repository.LoansRepository;

@RestController
public class LoansController {
  @Autowired
  private LoansRepository loanRepository;

  @GetMapping("/myLoans")
  public List<Loans> getLoanDetails(@RequestParam int custId) {
    return loanRepository.findByCustomerIdOrderByStartDtDesc(custId);
  }
}
