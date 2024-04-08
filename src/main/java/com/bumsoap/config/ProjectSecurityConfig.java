package com.bumsoap.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@ formatter-off
@Configuration
public class ProjectSecurityConfig {
  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
      throws Exception {
    http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
//    http.authorizeHttpRequests(requests -> requests
//        .requestMatchers("/myCards", "/myAccount", "/myBalance", "/myLoans")
//        .authenticated()
//        .requestMatchers("/notices", "/contact")
//        .permitAll())
//    .formLogin(withDefaults())
//    .httpBasic(withDefaults());
//    return http.build();
  }
//@ formatter-on
}
