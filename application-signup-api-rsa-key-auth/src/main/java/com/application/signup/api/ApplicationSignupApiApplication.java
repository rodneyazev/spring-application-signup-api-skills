package com.application.signup.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.application.signup.api.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class ApplicationSignupApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationSignupApiApplication.class, args);
	}

}