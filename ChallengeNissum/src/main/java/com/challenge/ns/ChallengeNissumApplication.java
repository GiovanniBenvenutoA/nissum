package com.challenge.ns;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpMethod;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import com.challenge.ns.filter.JWTAuthorizationFilter;

@SpringBootApplication

public class ChallengeNissumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeNissumApplication.class, args);
	}
	
	

}
