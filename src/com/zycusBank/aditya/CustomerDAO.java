package com.zycusBank.aditya;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class CustomerDAO implements CommonDAO<Customer> {
	
	private static final String SQL_SELECT="select firstName,lastName,title,age,dob from customerBank";
	private static final String SQL_INSERT="insert into customers(firstName,lastName,title,age,dob,pass,id) values(?,?,?,?,?,?,?)";

	@Override
	public void create(Customer customer,String pass) {
		
		System.out.println(pass);
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			
			String id = String.valueOf(System.nanoTime());
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getTitle());
			ps.setInt(4, customer.getAge());
			ps.setDate(5, customer.getDob());
			ps.setString(6, pass);
			ps.setString(7, id);
			ps.executeUpdate();
			System.out.println("Your Id is(use this id to login) : "+id);
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				
				customer.setFirstName(rs.getString(1));
				customer.setLastName(rs.getString(2));
				customer.setTitle(rs.getString(3));
				customer.setAge(rs.getInt(4));
				customer.setDob(rs.getDate(5));
				
				customers.add(customer);
			}
			
			return customers;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Customer findById(String id) {
		
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement("select firstName,lastName,title,age,dob from customerBank where id = ? ");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			Customer customer = new Customer();
			if(rs.next()) {
				customer.setId(rs.getString("id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setTitle(rs.getString("title"));
				customer.setAge(rs.getInt("age"));
				customer.setDob(rs.getDate("dob"));
				customer.setPass(rs.getString("pass"));
			}
			return customer;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	

}
