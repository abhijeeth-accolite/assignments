package com.something.SpringMVC;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/student")
@Controller
public class StudentController {    
    @Autowired    
    StudentDAO studentDAO;  
    
    @RequestMapping(value="/index",method = RequestMethod.GET)    
    public String indexRoute(Model m){
    	System.out.println("\n\n\n\n\n\nStudent fetched using RowMapper : ");
        List<Student> students = studentDAO.getStudentsUsingRowMapper();
        System.out.println(students);
        m.addAttribute("students",students);  
    	System.out.println("\nStudent fetched using ResultSetExtractor : ");
        students = studentDAO.getStudentsUsingResultSetExtractor();
        System.out.println(students);
        return "StudentShow";    
        
    }   
    
    @RequestMapping(value="/create",method = RequestMethod.POST)    
    public String createRoute(@ModelAttribute("student") Student student){    
        System.out.println(studentDAO.insertStudent(student));    
        return "redirect:/student/index";
    }    
    
    @RequestMapping(value="/new")    
    public String newRoute(Model m){    
        m.addAttribute("student", new Student());  
        return "StudentCreate";   
    }    
}  