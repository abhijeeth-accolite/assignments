package com.something.SpringMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertStudent(Student student) {
		String query = "insert into student(STUDENT_ID, STUDENT_NAME, STUDENT_GENDER, STUDENT_AGE) values (?, ?, ?, ?)";
		return jdbcTemplate.update(query, new Object[] { student.getStudentId(), student.getStudentName(),
				student.getStudentGender(), student.getStudentAge() });
	}

	public List<Student> getStudentsUsingRowMapper() {
		String query = "SELECT * FROM student";
		return jdbcTemplate.query(query, new StudentRowMapper());
	}

	public List<Student> getStudentsUsingResultSetExtractor() {
		String query = "SELECT * FROM student";
		return jdbcTemplate.query(query, new StudentResultSetExtractor());
	}
}
