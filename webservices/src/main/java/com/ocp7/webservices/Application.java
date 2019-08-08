package com.ocp7.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ocp7.webservices")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
