package com.zycusBank.account;

public class Transaction {
	
	public BranchParent branch;
	Transaction(BranchParent branch){
		this.branch = branch;
	}
	
	public boolean withdraw(long accountNumber,long amount){
		Account acc = this.branch.getAccount(accountNumber);
		long wBalance = 0l;
		if(acc != null && acc.getStatus().equals(AccountStatus.ACTIVE)){
			wBalance =acc.getBalanace();
			if(wBalance-amount < 1000){
				System.out.println("Withdrawal denied due no sufficient balance");
				return false;
			}
			else{
				acc.setBalanace(wBalance-amount);
				System.out.println("amount withdrawal done");
				return true;
			}
		}else{
			System.out.println("No Account Found OR It is not Active");
			return false;
		}
	}
	
	public boolean deposit(long accountNumber,long amount){
		Account acc = this.branch.getAccount(accountNumber);
		if(acc != null && acc.getStatus().equals(AccountStatus.ACTIVE)){
			acc.setBalanace(acc.getBalanace() + amount);
			System.out.println("amount deposited\n");
			return true;
		}
		else{
			System.out.println("please provide valid account No. or Your Account is Not Active ");
			return false;
		}
	}
	
	public boolean transfer(long sourceAccountNumber ,long destinationAccountNumber,long amount){
		if(withdraw(sourceAccountNumber, amount)){
			if(deposit(destinationAccountNumber, amount)){
				return true;
				
			}
			else{
				deposit(sourceAccountNumber, amount);
				System.out.println("Something wrong with Destination Account");
				return false;
			}
			
		}
		else{
			System.out.println("Something wrong with Source Account");
			return false;
		}
		
	}
}
