package com.something.someHibernateProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class App {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// inserting a new student
		session.beginTransaction();
		Student s1 = new Student();
		s1.setStudentAge(21);
		s1.setStudentName("Abhijeeth");
		s1.setStudentGender("male");
		int newStudentId = (Integer) session.save(s1);
		System.out.println("Generated student id : " + newStudentId + "\n");
		session.getTransaction().commit();

		// getting student with specific ID
		Criteria studentCr = session.createCriteria(Student.class);
		studentCr.add(Restrictions.eq("studentId", newStudentId));
		System.out.println("Inserted student : " + studentCr.list().get(0) + "\n" );

		// insert courses for newly inserted student
		session.beginTransaction();
		Course c1 = new Course();
		c1.setCourseName("J2EE");
		c1.setStudentId(newStudentId);
		Course c2 = new Course();
		c2.setCourseName("HIBERNATE");
		c2.setStudentId(newStudentId);
		session.getTransaction().commit();
		
		// get all courses of inserted student
		Criteria coursecr = session.createCriteria(Student.class);
		coursecr.add(Restrictions.eq("studentId", newStudentId));
		List<Student> studentList = new ArrayList<Student>();
		studentList = coursecr.list();
		int i = 0;
		System.out.println("inserted courses : ");
		for (Student student : studentList) {
			System.out.println(student.getCourses().get(i).getCourseName());
			i++;
		}
		session.close();
	}
}
