package com.bumsoap.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bumsoap.model.Contact;
import com.bumsoap.repository.ContactRepository;

@RestController
public class ContactController {

  @Autowired
  private ContactRepository contactRepository;

  @PostMapping("/contact")
  @PreFilter("filterObject.contactName != 'Test'")
  public List<Contact> saveUserInquiryDetails(
      @RequestBody List<Contact> contacts) {
    Contact contact = contacts.get(0);
    contact.setContactId(getServiceReqNumber());
    contact.setCreateDt(new Date(System.currentTimeMillis()));
    List<Contact> result = new ArrayList<>();
    result.add(contactRepository.save(contact));
    return result;
  }

  public String getServiceReqNumber() {
    Random random = new Random();
    int ranNum = random.nextInt(9_9999_9999 - 9999) + 9999;
    return "SR" + ranNum;
  }
}
