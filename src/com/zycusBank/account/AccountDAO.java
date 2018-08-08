package com.zycusBank.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.zycusBank.aditya.ConnectionUtil;
import com.zycusBank.bank.Bank;

public class AccountDAO {

	private static final String SQL_SELECT="select accountNo,accountType,bankCode,branchCode,customerId,balance from accounts";
	private static final String SQL_INSERT="insert into accounts(accountNo,accountType,bankCode,branchCode,customerId,balance) values(?,?,?,?,?,?)";

	
	public void create(Account account) {
		

		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			
			
			ps.setString(1, account.getAccountNo());
			ps.setString(2, account.getAccountType());
			ps.setString(3, account.getBankCode());
			ps.setString(4, account.getBranchCode());
			ps.setString(5, account.getCustomerId());
			ps.setDouble(6, account.getBalance());
	
			ps.executeUpdate();
			System.out.println("New Account Added  : "+account.getAccountNo());
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	
	public List<Account> findAll() {
		List<Account> accounts = new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				
				account.setAccountNo(rs.getString(1));
				account.setAccountType(rs.getString(2));
				account.setBankCode(rs.getString(3));
				account.setBranchCode(rs.getString(4));
				account.setCustomerId(rs.getString(5));
				account.setBalance(rs.getDouble(6));
				accounts.add(account);
			}
			
			return accounts;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	
	public Account findAccountByCode(String accountNo,String bankCode,String branchCode) {
		
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement("select accountNo,accountType,bankCode,branchCode,customerId,balance from accounts where accountNo = ? AND bankCode = ? AND branchCode = ?");
			ps.setString(1, accountNo);
			ps.setString(2, bankCode);
			ps.setString(3, branchCode);
			ResultSet rs = ps.executeQuery();
			Account account = new Account();
			if(rs.next()) {
				account.setAccountNo(rs.getString("accountCode"));
				account.setAccountType(rs.getString("accountType"));
				account.setBankCode(rs.getString("bankCodeCode"));
				account.setBranchCode(rs.getString("branchCode"));
				account.setCustomerId(rs.getString("customerId"));
				account.setBalance(rs.getDouble("balance"));
				
				
			}
			return account;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<Account> findAccountByCustomerId(String customerId) {
		
		List<Account> accounts = new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			
			PreparedStatement ps = con.prepareStatement("select accountNo,accountType,bankCode,branchCode,customerId,balance from accounts where customerId = ?");
			ps.setString(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				
				account.setAccountNo(rs.getString(1));
				account.setAccountType(rs.getString(2));
				account.setBankCode(rs.getString(3));
				account.setBranchCode(rs.getString(4));
				account.setCustomerId(rs.getString(5));
				account.setBalance(rs.getDouble(6));
				accounts.add(account);
			}
			
			return accounts;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
