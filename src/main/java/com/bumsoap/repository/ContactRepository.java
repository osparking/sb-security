package com.bumsoap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bumsoap.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {

}
