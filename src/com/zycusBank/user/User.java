package com.zycusBank.user;

import java.sql.Date;

import com.zycusBank.enums.Role;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String title;
	private String mobile;
	private Date dob;
	private String aadhaarNo;
	private String pass;
	private Role role;

	public User(String firstName, String lastName, String title, String mobile, Date dob, Role role, String aadhaarNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.mobile = mobile;
		this.dob = dob;
		this.role = role;
		this.aadhaarNo = aadhaarNo;
	}

	public User() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", mobile=" + mobile + ", dob=" + dob + ", aadhaarNo=" + aadhaarNo + ", pass=" + pass + ", role="
				+ role + "]";
	}

	

}
