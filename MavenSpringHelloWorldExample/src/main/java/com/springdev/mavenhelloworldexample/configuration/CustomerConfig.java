package com.springdev.mavenhelloworldexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springdev.mavenhelloworldexample.beans.Customer;

@Configuration
public class CustomerConfig {

	@Bean
	public Customer customer() {
		return new Customer();
	}
	
}
