package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.Customer;
import com.bumsoap.repository.CustomerRepository;

@RestController
public class LoginController {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody Customer customer) {
    Customer result = null;
    ResponseEntity<String> response = null;

    customer.setPwd(passwordEncoder.encode(customer.getPwd()));

    try {
      result = customerRepository.save(customer);
      if (result.getId() > 0) {
        response = ResponseEntity.status(HttpStatus.CREATED)
            .body("요청된 고객 등록이 성공했습니다.");
      }
    } catch (Exception ex) {
      response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("발생 오류 : " + ex.getMessage());
    }
    return response;
  }

  @GetMapping("/user")
  public Customer getUserDetailsAfterLogin(Authentication authentication) {
    List<Customer> customers = customerRepository
        .findByEmail(authentication.getName());
    if (customers.size() > 0) {
      return customers.get(0);
    } else {
      return null;
    }
  }

}
