package com.bumsoap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private int id;
  private String name;
  private String email;

  @Column(name = "mobile_number")
  private String mobileNumber;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String pwd;
  private String role;

  @Column(name = "create_dt")
  private String createDt;

}
