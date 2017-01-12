package com.springdev.mavenhelloworldexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdev.mavenhelloworldexample.beans.Customer;
import com.springdev.mavenhelloworldexample.beans.HelloWorld;
import com.springdev.mavenhelloworldexample.beans.OutputHelper;
import com.springdev.mavenhelloworldexample.configuration.AppConfig;

@SpringBootApplication
public class MavenSpringHelloWorldExampleApplication {

	public static void main(String[] args) {
		
		// load spring bean configuration file (beans.xml)
		// ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		// retrieve "helloBean" bean
		//HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		//obj.printHello();
		
		// retrieve "outputHelper" bean
		//OutputHelper obj2 = (OutputHelper) context.getBean("outputHelper");
		//obj2.generateOutput();
		
		//------------------- Using Java Configuration --------------------------------------
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//HelloWorld obj3 = (HelloWorld) context.getBean("helloWorld");
		//obj3.printHello();
		
		Customer obj4 = context.getBean("customer", Customer.class);
		System.out.println(obj4);
		
		
		
		SpringApplication.run(MavenSpringHelloWorldExampleApplication.class, args);
		
	}
	
}
