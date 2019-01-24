package com.spring.au.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.spring.au.model.Student;
import com.spring.au.rowmapper.StudentRowMapper;

@Repository
public class StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Student> getStudents() {
		String query = "SELECT * FROM student";
		return jdbcTemplate.query(query, new StudentRowMapper());
	}

	public Student insertStudent(Student student) {

		jdbcTemplate.update("INSERT INTO student VALUES (" + student.getStudentId() + ", '" + student.getStudentName()
				+ "', '" + student.getStudentGender() + "', " + student.getStudentAge() + ")");
		return student;
	}
}
