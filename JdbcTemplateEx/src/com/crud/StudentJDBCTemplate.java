package com.crud;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {

	@Autowired
	public DataSource dataSource;

	public JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public void create(String name, Integer age) {
		String sql = "INSERT INTO Student (name, age) VALUES (?,?)";
		jdbcTemplateObject.update(sql, name, age);
		System.out.println("Created Record Name: " + name + ", Age: " + age);
	}

	@Override
	public Student getStudent(Integer id) {
		String sql = "SELECT * FROM Student WHERE id = ?";
		Student student = jdbcTemplateObject.queryForObject(sql, new StudentMapper(), id);

		return student;
	}

	@Override
	public List<Student> listStudents() {
		String sql = "Select * from Student";

		List<Student> studentList = jdbcTemplateObject.query(sql, new StudentMapper());

		return studentList;
	}

	@Override
	public void deleteStudent(Integer id) {
		String sql = "DELETE FROM Student WHERE id = ?";
		jdbcTemplateObject.update(sql, id);

		System.out.println("Deleted Record with ID = " + id);
	}

	@Override
	public void update(Integer id, Integer age) {
		String sql = "UPDATE Student set age = ? where id = ?";

		jdbcTemplateObject.update(sql, age, id);

		System.out.println("Updated Record with ID = " + id);

	}

}
