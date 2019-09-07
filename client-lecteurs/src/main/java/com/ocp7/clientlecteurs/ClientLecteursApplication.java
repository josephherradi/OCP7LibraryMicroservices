package com.ocp7.clientlecteurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= "com.ocp7.clientlecteurs")
@SpringBootApplication
@EnableFeignClients("com.ocp7.clientlecteurs")
public class ClientLecteursApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClientLecteursApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ClientLecteursApplication.class);
	}
}
