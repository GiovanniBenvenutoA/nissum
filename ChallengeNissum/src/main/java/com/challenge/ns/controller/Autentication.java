package com.challenge.ns.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.ns.models.Login;
import com.challenge.ns.models.MensajeRespuesta;
import com.challenge.ns.services.IuserService;
import com.google.gson.Gson;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/api" })
public class Autentication {
	
	private static Logger log = LoggerFactory.getLogger(Autentication.class);
	
	@Autowired
	IuserService userService;
	
	
	@PostMapping("/login")
	public String login(@RequestBody String request) {
		
		log.info("request"+request);
		
		String email = "";
		String password = "";
		MensajeRespuesta respuestaError = new MensajeRespuesta();
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonrow=(JSONObject)parser.parse(String.valueOf(request));
			email =(String)jsonrow.get("email");
			password =(String)jsonrow.get("password");
			boolean response = userService.ValidateEmail(email);
			boolean responsepass = userService.validaPassword(password);
			if(response == false && responsepass ==true) {
				userService.InsertData(request);
			}else {
				
				respuestaError.setCodigo("-1");
				respuestaError.setMensaje("El correo ya esta registrado");
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return password;
		
		
		
	}

	

}
