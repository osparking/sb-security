package com.bumsoap.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bumsoap.model.Customer;
import com.bumsoap.repository.CustomerRepository;

@Service
public class EasyBankUserService implements UserDetailsService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    String password;
    List<GrantedAuthority> authorities;
    List<Customer> customer = customerRepository.findByEmail(username);

    if (customer.size() == 0) {
      throw new UsernameNotFoundException("사용자로 등록되지 않은 이메일: " + username);
    } else {
      password = customer.get(0).getPwd();
      authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
    }
    return new User(username, password, authorities);
  }

}
