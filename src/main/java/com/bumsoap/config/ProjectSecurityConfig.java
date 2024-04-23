package com.bumsoap.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.bumsoap.filter.CsrfCookieFilter;
import com.bumsoap.filter.CustomRequestValidationFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class ProjectSecurityConfig {

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
      throws Exception {
    var requestHandler = new CsrfTokenRequestAttributeHandler();
    requestHandler.setCsrfRequestAttributeName("_csrf");

    // @formatter:off
    http.securityContext((context) -> context.requireExplicitSave(false))
        .sessionManagement(session -> 
              session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
        .cors(corsCustomizer -> corsCustomizer
        .configurationSource(new CorsConfigurationSource() {
          @Override
          public CorsConfiguration getCorsConfiguration(
              HttpServletRequest request) {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(
                Collections.singletonList("http://localhost:4200"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowCredentials(true);
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setMaxAge(3600L);
            return config;
          }
        }))
        .csrf(csrf -> csrf.csrfTokenRequestHandler(requestHandler)
            .ignoringRequestMatchers("/contact", "/register")
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
        .addFilterBefore(new CustomRequestValidationFilter(), 
                                                BasicAuthenticationFilter.class)
        .authorizeHttpRequests(requests -> requests
            .requestMatchers("/myAccount").hasRole("USER")
            .requestMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
            .requestMatchers("/myLoans").hasRole("USER")
            .requestMatchers("/myCards").hasRole("USER")
            
            .requestMatchers("/notices", "/contact", "/register")
                .permitAll()
            .requestMatchers("/user").authenticated())
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
    // @formatter:on
  }
}
