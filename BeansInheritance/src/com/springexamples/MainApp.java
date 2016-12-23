package com.springexamples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		HelloExtension objB = (HelloExtension) context.getBean("helloExtension");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();

	}
}
