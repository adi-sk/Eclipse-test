package com.zycusBank.user;

import java.sql.Date;

import com.zycusBank.enums.Role;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String title;
	private int age;
	private Date dob;
	private String pass;
	private Role role;

	public User(String firstName, String lastName, String title, int age, Date dob, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.age = age;
		this.dob = dob;
		this.role = role;
	}

	public User() {

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + ", age=" + age
				+ ", dob=" + dob + "]";
	}

}
