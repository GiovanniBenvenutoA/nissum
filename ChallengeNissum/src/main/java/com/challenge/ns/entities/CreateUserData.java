package com.challenge.ns.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class CreateUserData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7350176048552798458L;
	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="phones_number")
	private String phones_number;
	@Column(name="phones_citycode")
	private String phones_citycode;
	@Column(name="phones_contrycode")
	private String phones_contrycode;
	@Column(name="created")
	private String created;
	@Column(name="modified")
	private String modified;
	@Column(name="last_login")
	private String last_login;
	@Column(name="isactive")
	private String isactive;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhones_number() {
		return phones_number;
	}
	public void setPhones_number(String phones_number) {
		this.phones_number = phones_number;
	}
	public String getPhones_citycode() {
		return phones_citycode;
	}
	public void setPhones_citycode(String phones_citycode) {
		this.phones_citycode = phones_citycode;
	}
	public String getPhones_contrycode() {
		return phones_contrycode;
	}
	public void setPhones_contrycode(String phones_contrycode) {
		this.phones_contrycode = phones_contrycode;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isactive == null) ? 0 : isactive.hashCode());
		result = prime * result + ((last_login == null) ? 0 : last_login.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phones_citycode == null) ? 0 : phones_citycode.hashCode());
		result = prime * result + ((phones_contrycode == null) ? 0 : phones_contrycode.hashCode());
		result = prime * result + ((phones_number == null) ? 0 : phones_number.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateUserData other = (CreateUserData) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isactive == null) {
			if (other.isactive != null)
				return false;
		} else if (!isactive.equals(other.isactive))
			return false;
		if (last_login == null) {
			if (other.last_login != null)
				return false;
		} else if (!last_login.equals(other.last_login))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phones_citycode == null) {
			if (other.phones_citycode != null)
				return false;
		} else if (!phones_citycode.equals(other.phones_citycode))
			return false;
		if (phones_contrycode == null) {
			if (other.phones_contrycode != null)
				return false;
		} else if (!phones_contrycode.equals(other.phones_contrycode))
			return false;
		if (phones_number == null) {
			if (other.phones_number != null)
				return false;
		} else if (!phones_number.equals(other.phones_number))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CreateUserData [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phones_number=" + phones_number + ", phones_citycode=" + phones_citycode + ", phones_contrycode="
				+ phones_contrycode + ", created=" + created + ", modified=" + modified + ", last_login=" + last_login
				+ ", isactive=" + isactive + "]";
	}
	
	
	
	
	

}
