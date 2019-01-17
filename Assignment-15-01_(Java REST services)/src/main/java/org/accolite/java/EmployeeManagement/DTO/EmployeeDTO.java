package org.accolite.java.EmployeeManagement.DTO;

public class EmployeeDTO {

	private String name;
	private int age;
	private int id;
	
	public EmployeeDTO(String name, int age, int id){
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	public EmployeeDTO() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.name + " <"+this.id+"> age("+this.age+")";
	}
}
