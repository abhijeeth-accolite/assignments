package com.something.SpringMVC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getString("STUDENT_ID"));
		student.setStudentName(rs.getString("STUDENT_NAME"));
		student.setStudentGender(rs.getString("STUDENT_GENDER"));
		student.setStudentAge(rs.getInt("STUDENT_AGE"));
		return student;
	}

}
