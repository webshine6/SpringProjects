package com.crud;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		StudentJDBCTemplate studentJDBSTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		// System.out.println("------Records Creation--------");
		// studentJDBSTemplate.create("Mariq", 59);
		//
		// System.out.println("------Listing record with id 2--------");
		// Student student = studentJDBSTemplate.getStudent(1);
		// System.out.println("ID: " + student.getId());
		// System.out.println("Name: " + student.getName());
		// System.out.println("Age: " + student.getAge());

		System.out.println("------Listing multiple students records--------");
		List<Student> students = studentJDBSTemplate.listStudents();
		for (Student record : students) {
			System.out.print("ID: " + record.getId());
			System.out.print(", name: " + record.getName());
			System.out.println(", age: " + record.getAge());

		}

		System.out.println("------ Delete record with id 1 --------");
		studentJDBSTemplate.deleteStudent(1);

	}

}
