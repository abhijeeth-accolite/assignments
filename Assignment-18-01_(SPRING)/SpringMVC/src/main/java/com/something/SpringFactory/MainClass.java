package com.something.SpringFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {  
	    ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");  
	    MyInterface myObject = context.getBean("mybean", MyInterface.class);  
	    myObject.myMethod();  
	}  
}
