package com.springboot.assetmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
		"com.springboot.login.base",
		"com.springboot.login.controller",
		"com.springboot.login.config",
		"com.springboot.login.dao",
		"com.springboot.login.dto.login",
		"com.springboot.login.security",
		"com.springboot.login.service",
		"com.springboot.login.model",
		"com.springboot.assetmanagement.base",
		"com.springboot.assetmanagement.controller",
		"com.springboot.assetmanagement.dao",
		"com.springboot.assetmanagement.dto",
		"com.springboot.assetmanagement.model",
		"com.springboot.assetmanagement.service"
})
@EntityScan(basePackages = {
		"com.springboot.login.model",
		"com.springboot.assetmanagement.model"
})
public class MainSpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(MainSpringBoot.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
