package com.springdev.mavenhelloworldexample.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {
	
	@Value("#{addressBean}")
	private Address address;
	
	@Value("#{addressBean.country}")
	private String country;
	
	@Value("#{addressBean.city}")
	private String city;
	
	@Value("#{addressBean.street}")
	private String street;
	
	@Value("#{addressBean.getFullAddress('bg')}")
	private String fullAddrees;
	
	public static void printMsg() {
		System.out.println("Greeting Message");
	}

	public String getFullAddrees() {
		return fullAddrees;
	}

	@Override
	public String toString() {
		return new StringBuffer("Full Address: " + fullAddrees).toString();
	}
	

}
