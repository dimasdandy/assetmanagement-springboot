package com.springboot.assetmanagement.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.client.RestTemplate;


public class AuthorizationFilter extends BasicAuthenticationFilter {

	private RestTemplate restTemplate;

	public AuthorizationFilter(AuthenticationManager authenticationManager, RestTemplate restTemplate) {
		super(authenticationManager);
		this.restTemplate = restTemplate;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String header = request.getHeader("Authorization");
		if (header == null || header.isEmpty() || !header.startsWith("Bearer")) {
			throw new RuntimeException("invalid token.");
		}
		String token = header.substring(7, header.length());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(token);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("token", token);
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(map, headers);
		restTemplate.exchange("http://localhost:8083/api/token", HttpMethod.POST, entity, String.class);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(token, null, null);
		SecurityContextHolder.getContext().setAuthentication(auth);
		chain.doFilter(request, response);
	}

}
