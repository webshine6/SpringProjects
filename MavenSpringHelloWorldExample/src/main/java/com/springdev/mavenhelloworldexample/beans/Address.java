package com.springdev.mavenhelloworldexample.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "addressBean")
public class Address {

	@Value("Bulgara")
	private String country;
	
	@Value("Ruse")
	private String city;
	
	@Value("Borisova")
	private String street;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getFullAddress(String prefix) {
		return prefix + " : " + getCountry() + " : " + getCity() + " : "  +getStreet();
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street=" + street + "]";
	}
	
}
