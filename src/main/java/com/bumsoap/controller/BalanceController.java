package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
  @GetMapping("/myBalance")
  public String getBalanceDetails() {
    return "이것은 디비에서 읽어온 계정 잔고 상세";
  }

}
