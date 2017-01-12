package com.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int numRow) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setAge(rs.getInt("age"));
		student.setName(rs.getString("name"));
		return student;
	}

}