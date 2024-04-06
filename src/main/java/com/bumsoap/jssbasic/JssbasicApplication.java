package com.bumsoap.jssbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bumsoap.jssbasic.controller")
public class JssbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(JssbasicApplication.class, args);
	}

}
