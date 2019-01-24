package com.assignment.junit;

import java.util.HashMap;
import java.util.Map;

import com.opencsv.bean.CsvBindByName;

public class Student {

	private Integer studentId;
	private String studentName;
	private Integer studentAge;

	private Map<Subject, Mark> studentMarks = new HashMap<Subject, Mark>();

	public Student(Integer studentId, String studentName, Integer studentAge) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public Map<Subject, Mark> getStudentMarks() {
		return studentMarks;
	}

	public String[] getCSV() {
		return new String[] { studentId.toString(), studentName, studentAge.toString() };
	}

	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		return (s.getStudentId().equals(this.studentId) && s.getStudentName().equals(this.studentName)
				&& s.getStudentAge().equals(this.studentAge));
	}

}
