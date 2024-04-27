package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.Loans;
import com.bumsoap.repository.LoansRepository;

@RestController
public class LoansController {
  @Autowired
  private LoansRepository loanRepository;

  @PostAuthorize("hasRole('ROOT')")
  @GetMapping("/myLoans")
  public List<Loans> getLoanDetails(@RequestParam int id) {
    return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
  }
}
