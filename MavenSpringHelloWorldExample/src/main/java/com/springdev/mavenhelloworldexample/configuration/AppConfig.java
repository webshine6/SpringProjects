package com.springdev.mavenhelloworldexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.springdev.mavenhelloworldexample.beans.HelloWorld;

@Configuration
@Import(value = {CustomerConfig.class, AddressConfig.class})
public class AppConfig {

	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
	
}
