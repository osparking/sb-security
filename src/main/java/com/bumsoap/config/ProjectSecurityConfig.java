package com.bumsoap.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
      throws Exception {
    // @formatter:off
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(requests -> requests
        .requestMatchers("/notices", "/contact", "/register")
          .permitAll()
        .requestMatchers("/myCards", "/myAccount", "/myBalance", "/myLoans",
            "/user")
          .authenticated())
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
    // @formatter:on
  }
}
