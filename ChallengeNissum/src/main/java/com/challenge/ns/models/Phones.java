package com.challenge.ns.models;

import java.io.Serializable;

public class Phones implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8031798544136721755L;
	private String number;
	private String citycode;
	private String contrycode;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getContrycode() {
		return contrycode;
	}
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citycode == null) ? 0 : citycode.hashCode());
		result = prime * result + ((contrycode == null) ? 0 : contrycode.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Phones other = (Phones) obj;
		if (citycode == null) {
			if (other.citycode != null)
				return false;
		} else if (!citycode.equals(other.citycode))
			return false;
		if (contrycode == null) {
			if (other.contrycode != null)
				return false;
		} else if (!contrycode.equals(other.contrycode))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Phones [number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode + "]";
	}
	
	

}
