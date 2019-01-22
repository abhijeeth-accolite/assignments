package com.something.SpringMVC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getString("STUDENT_ID"));
			student.setStudentName(rs.getString("STUDENT_NAME"));
			student.setStudentGender(rs.getString("STUDENT_GENDER"));
			student.setStudentAge(rs.getInt("STUDENT_AGE"));
			students.add(student);
		}
		return students;
	}

}
