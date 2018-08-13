package com.zycusBank.account;



public class Account implements Comparable<Account>{
	private String accountNo ;
	private AccountType accountType;
	private String bankCode;
	private String branchCode;
	private String customerId;
	private double balance ;
	private AccountStatus status;
	
	
	
	
	public Account(String accountNo, AccountType accountType, String bankCode, String branchCode, String customerId,
			double balance, AccountStatus status) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.bankCode = bankCode;
		this.branchCode = branchCode;
		this.customerId = customerId;
		this.balance = balance;
		this.status = status;
		
	}
	
	public Account(){
		
	}



	public String getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getBankCode() {
		return bankCode;
	}



	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}



	public String getBranchCode() {
		return branchCode;
	}



	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		return 0;
	}


}

enum AccountType{
	SAVINGS,CURRENT;
}

enum AccountStatus{
	ACTIVE,CLOSED
}
