package com.spring.au.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.au.dao.impl.StudentDao;
import com.spring.au.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	

	public List<Student> getStudents() {
		return studentDao.getStudents();
	}
	
	public Student insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}
}
