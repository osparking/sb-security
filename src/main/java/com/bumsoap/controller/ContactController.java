package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
  @GetMapping("/contact")
  public String saveUserInquiryDetails() {
    return "고객의 문의 내용이 디비에 저장됨";
  }

}
