package com.spring.au.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.spring.au.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getInt("STUDENT_ID"));
		student.setStudentName(rs.getString("STUDENT_NAME"));
		student.setStudentGender(rs.getString("STUDENT_GENDER"));
		student.setStudentAge(rs.getInt("STUDENT_AGE"));
		return student;
	}

}
