package com.bumsoap.jssbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
  
  @GetMapping("/welcome")
  public String sayWelcome() {
    return "보안 수준이 높아진 봄 응용에 환영합니다.";
  }

}
