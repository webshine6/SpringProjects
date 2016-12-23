package com.eventhandling;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// raise a Start Event
		context.start();

		HelloWorld hWorld = (HelloWorld) context.getBean("helloWorld");
		hWorld.getMessage();

		// raise a Stop Event
		context.stop();

	}

}
