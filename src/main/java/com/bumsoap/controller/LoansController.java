package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
  @GetMapping("/myLoans")
  public String getLoanDetails() {
    return "이것은 디비에서 읽어온 대출 계정 상세";
  }

}
