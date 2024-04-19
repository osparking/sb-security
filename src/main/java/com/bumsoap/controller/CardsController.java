package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
  @GetMapping("/myCards")
  public String getCardDetails() {
    return "이것은 디비에서 읽어온 금융 카드 상세";
  }

}
