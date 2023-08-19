package model;

import java.util.Date;

public class Student {

	private Integer id;
	private String name;
	private Boolean gender;
	private Date age;
	
	public Student() {
	}
	
	public Student(Integer id, String name, Boolean gender, Date age) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	
	
}
