package com.springdev.mavenhelloworldexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springdev.mavenhelloworldexample.beans.Address;

@Configuration
public class AddressConfig {

	@Bean(name = "addressBean")
	public Address address() {
		return new Address();
	}
}
