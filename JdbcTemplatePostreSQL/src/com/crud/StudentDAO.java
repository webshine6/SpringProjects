package com.crud;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {

	// Initialize database connection
	public void setDataSource(DataSource ds);

	// Create record in Student table
	public void create(String name, Integer age);

	// Get student record by passed id
	public Student getStudent(Integer id);

	// Get all records from student table
	public List<Student> listStudents();

	// Delete student record by passed id
	public void deleteStudent(Integer id);

	// Update student record
	public void update(Integer id, Integer age);
}
