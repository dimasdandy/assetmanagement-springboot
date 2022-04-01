package com.springboot.assetmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

@EnableWebSecurity
public class ApiSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated();

		// authorization
		http.addFilter(new AuthorizationFilter(super.authenticationManager(), restTemplate));
	}
	
}
