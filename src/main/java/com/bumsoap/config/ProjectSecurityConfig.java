package com.bumsoap.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  @Bean
  InMemoryUserDetailsManager userDetailsService() {
    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("1111")
        .authorities("admin")
        .build();
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("1111")
        .authorities("read")
        .build();
    return new InMemoryUserDetailsManager(admin, user);
  }

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
      throws Exception {
    // @formatter:off
    http.authorizeHttpRequests(requests -> requests
        .requestMatchers("/notices", "/contact")
          .permitAll()
        .requestMatchers("/myCards", "/myAccount", "/myBalance", "/myLoans")
          .authenticated())
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
    // @formatter:on
  }
}
