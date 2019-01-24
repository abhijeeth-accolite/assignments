package com.spring.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.au.model.Student;
import com.spring.au.service.impl.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping("/")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
}