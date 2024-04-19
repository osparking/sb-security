package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @GetMapping("/myAccount")
  public String getAccountDetails() {
    return "디비에서 읽어온 계정 상세";
  }

}
