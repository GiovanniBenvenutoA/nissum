package com.challenge.ns.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.ns.entities.CreateUserData;

@Repository
public interface IvalidationEmailDao extends CrudRepository<CreateUserData, String>{
	
	@Query(value="select * from USUARIOS  where email =  ?1", nativeQuery = true)
	String validateEmail(String email);
	
	@Modifying
	@Query(value="insert into USUARIOS (id,name,email,password,phone_number,phone_citycode,phone_contrycode,created,modified,last_login,token,isactive) values (:id,:name,:email,password:phone_number,:phone_citycode,:phone_contrycode,:created,:modified,:last_login,:token,:isactive)",nativeQuery = true)
	@Transactional
	public CreateUserData InserUserData
	(
			String id,
			String name,
			String email,
			String password,
			String phone_number,
			String phone_citycode,
			String phone_contrycode,
			String created,
			String modified,
			String last_login,
			String token,
			String isactive
	);

}
