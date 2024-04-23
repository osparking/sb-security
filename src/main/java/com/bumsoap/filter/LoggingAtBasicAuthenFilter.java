package com.bumsoap.filter;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LoggingAtBasicAuthenFilter implements Filter {

  private final Logger logger = Logger
      .getLogger(LoggingAtBasicAuthenFilter.class.getName());

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {

    logger.info("인증 진행 중입니다.");
    chain.doFilter(request, response);
  }
}
