package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
  @GetMapping("/notices")
  public String getNotices() {
    return "이것은 디비에서 읽어온 고지 내용 상세";
  }

}
