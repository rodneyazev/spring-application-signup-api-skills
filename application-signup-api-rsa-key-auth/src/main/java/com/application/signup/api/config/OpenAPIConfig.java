package com.application.signup.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI myOpenAPI() {
		Info info = new Info()
	        .title("Spring Boot Rest API - Signup API")
	        .version("1.0")
	        .description("A signup Rest API template.");
	    return new OpenAPI().info(info);
	}

}