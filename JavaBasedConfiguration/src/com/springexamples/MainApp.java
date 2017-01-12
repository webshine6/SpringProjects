package com.springexamples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorld.class);

		HelloWorld hWorld = context.getBean(HelloWorld.class);

		hWorld.setMessage("Hello World!");
		hWorld.getMessage();
	}
}
