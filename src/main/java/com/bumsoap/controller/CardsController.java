package com.bumsoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.Cards;
import com.bumsoap.repository.CardsRepository;

@RestController
public class CardsController {

  @Autowired
  private CardsRepository cardsRepository;

  @GetMapping("/myCards")
  public List<Cards> getCardDetails(@RequestParam int custId) {
    return cardsRepository.findByCustomerId(custId);
  }
}
