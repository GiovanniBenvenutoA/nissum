package com.challenge.ns.services;

import com.challenge.ns.entities.CreateUserData;
import com.challenge.ns.models.Login;

public interface IuserService {

	boolean ValidateEmail(String email);

	CreateUserData InsertData(String email);

	Boolean validaPassword(String email);

}
