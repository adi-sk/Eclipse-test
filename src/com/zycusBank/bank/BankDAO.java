package com.zycusBank.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.zycusBank.aditya.ConnectionUtil;
import com.zycusBank.bank.Bank;

public class BankDAO {
	
	private static final String SQL_SELECT="select bankCode,bankName from banks";
	private static final String SQL_INSERT="insert into banks(bankCode,bankName) values(?,?)";

	
	public boolean create(Bank bank) {
		

		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			
			
			ps.setString(1, bank.getBankCode());
			ps.setString(2, bank.getBankName());
	
			ps.executeUpdate();
			System.out.println("New Bank Added  : "+bank.getBankCode());
			return true;
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	
	public List<Bank> findAll() {
		List<Bank> banks = new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Bank bank = new Bank();
				
				bank.setBankCode(rs.getString(1));
				bank.setBankName(rs.getString(2));
				banks.add(bank);
			}
			
			return banks;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	
	public Bank findByCode(String bankCode) {
		
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement("select bankCode,bankName from banks where bankCode = ? ");
			ps.setString(1, bankCode);
			ResultSet rs = ps.executeQuery();
			Bank bank = new Bank();
			if(rs.next()) {
				bank.setBankCode(rs.getString("bankCode"));
				bank.setBankName(rs.getString("bankName"));
				
			}
			return bank;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
