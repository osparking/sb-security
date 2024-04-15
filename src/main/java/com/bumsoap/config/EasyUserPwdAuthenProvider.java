package com.bumsoap.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bumsoap.repository.CustomerRepository;

@Component
public class EasyUserPwdAuthenProvider implements AuthenticationProvider {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication)
      throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();
    var customers = customerRepository.findByEmail(username);

    if (customers.size() > 0) {
      if (passwordEncoder.matches(password, customers.get(0).getPwd())) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        return new UsernamePasswordAuthenticationToken(username, password,
            authorities);
      } else {
        throw new BadCredentialsException("비밀번호가 잘못되었습니다!");
      }
    } else {
      throw new BadCredentialsException("입력한 정보에 해당하는 고객은 없습니다.");
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class
        .isAssignableFrom(authentication));
  }

}
