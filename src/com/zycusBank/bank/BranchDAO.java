package com.zycusBank.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.zycusBank.aditya.ConnectionUtil;

public class BranchDAO {

	private static final String SQL_SELECT="select branchCode,branchName from branches";
	private static final String SQL_INSERT="insert into branches(branchCode,branchName) values(?,?)";

	
	public void create(Branch branch) {
		

		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			
			
			ps.setString(1, branch.getBranchCode());
			ps.setString(2, branch.getBranchName());
	
			ps.executeUpdate();
			System.out.println("New Branch Added  : "+branch.getBranchCode());
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	
	public List<Branch> findAll() {
		List<Branch> branchs = new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Branch branch = new Branch();
				
				branch.setBranchCode(rs.getString(1));
				branch.setBranchName(rs.getString(2));
				branchs.add(branch);
			}
			
			return branchs;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	
	public Branch findByCode(String branchCode) {
		
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement("select branchCode,branchName from branches where branchCode = ? ");
			ps.setString(1, branchCode);
			ResultSet rs = ps.executeQuery();
			Branch branch = new Branch();
			if(rs.next()) {
				branch.setBranchCode(rs.getString("branchCode"));
				branch.setBranchName(rs.getString("branchName"));
				
			}
			return branch;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
