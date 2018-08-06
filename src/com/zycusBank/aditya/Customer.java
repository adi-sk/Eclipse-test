package com.zycusBank.aditya;

import java.sql.Date;

public class Customer {
	private String firstName;
	private String lastName;
	private String title;
	private int age;
	private Date dob;
	public Customer(String firstName, String lastName,String title,int age,Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.age = age;
		this.dob = dob;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Customer(){
		
	}
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + ", age=" + age
				+ ", dob=" + dob + "]";
	}
	
	
	
	
}
