package com.concretepage;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.concretepage.bean.Country;

public class RunApplication {
	public static void main(String[] args) throws IOException {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Converter converter = appContext.getBean(Converter.class);

		Country country = new Country();

		// Perform Marshaling
		country.setId(100);
		country.setCountryName("India");
		country.setPmName("ABC");

		converter.doMarshaling("country.xml", country);
		System.out.println("Marshaling performed");
		// Perform UnMarshaling
		country = (Country) converter.doUnMarshaling("country.xml");
		System.out.println(
				"After UnMarshaling Data is: id:" + country.getId() + ", CountryName:" + country.getCountryName());
	}
}
