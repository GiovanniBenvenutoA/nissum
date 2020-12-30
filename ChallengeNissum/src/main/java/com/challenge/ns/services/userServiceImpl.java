package com.challenge.ns.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.challenge.ns.dao.IvalidationEmailDao;
import com.challenge.ns.entities.CreateUserData;
import com.challenge.ns.models.Login;
import com.google.gson.Gson;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;



@Service
public class userServiceImpl implements IuserService {
	
	private static Logger log = LoggerFactory.getLogger(userServiceImpl.class);
	
	@Autowired
	IvalidationEmailDao UserDataJpa;
	
	@Override
	public boolean ValidateEmail(String email) {
		
		//valida si correo esta escrito correctamente
		boolean responsemail =false;
		
		boolean validaformcorreo =validaEmail(email);
		if(validaformcorreo ==true) {
			String respuesta = UserDataJpa.validateEmail(email);
			if(respuesta == null) {
				responsemail =false;
			}else if(respuesta.equals(email)){
				responsemail = false;
			}else {
				responsemail = true;
			}
		}else {
			responsemail = false; 
		}
		
		
		 return responsemail;
		
	}
	
	public static Boolean validaEmail (String email) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	
	@Override
	public  Boolean validaPassword (String email) {
		Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	
	@Override
	public CreateUserData InsertData(String request) {
		
		log.info(request);
		CreateUserData usuario =  new CreateUserData();
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonrow=(JSONObject)parser.parse(String.valueOf(request));
			
			UUID uuid = UUID.randomUUID();
			log.info("id"+uuid);
			LocalDateTime creacion = LocalDateTime.now();
			LocalDateTime modificacion = LocalDateTime.now();
			LocalDateTime last_login = LocalDateTime.now();
			log.info("login"+last_login);
			String token = getJWTToken(request);
			String isactive = "activo";
			String email = (String)jsonrow.get("email");
			String password = (String)jsonrow.get("password");
			String name = (String)jsonrow.get("name");
			//Deserealizar el objeto
			String phone_number = (String)jsonrow.get("number");
			log.info(phone_number);
			String phone_citycode = (String)jsonrow.get("citycode");
			String phone_contrycode = (String)jsonrow.get("contrycode");
			
			
			
			usuario=UserDataJpa.InserUserData(uuid.toString(),name,email,password,phone_number,phone_citycode,phone_contrycode,creacion.toString(), modificacion.toString(), last_login.toString(), token, isactive);
			log.info("datos"+usuario);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return usuario;
		
	}
	
	private String getJWTToken(String request) {
		
		 Gson gson = new Gson();    
		 String json = gson.toJson(request);
		 log.info(json);
		 
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(json)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
