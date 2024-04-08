package com.bumsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bumsoap.jssbasic.controller")
public class BumsoapBackendApp {

	public static void main(String[] args) {
    SpringApplication.run(BumsoapBackendApp.class, args);
	}

}
