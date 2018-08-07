package com.zycusBank.account;

import java.util.*;
import java.util.stream.Collectors;


public class BranchSet extends BranchParent {

	public static long branchCode = System.currentTimeMillis();
	private static long ACC_NO_GENERATOR = 1;
	Set<Account> accounts = new HashSet<>();
	
	public boolean openNewAccount(AccountType type,long balance,String accountHolder){
		Account account = new Account(ACC_NO_GENERATOR,branchCode,accountHolder,type,balance,AccountStatus.ACTIVE);
		
		if(this.accounts.add(account)){
			System.out.println("New Account Added");
			ACC_NO_GENERATOR++;
			return true;
		}
		return false;
		
	}
	
	public Account getAccount(long accountNumber){
		try{
		return accounts.stream().filter((x)->x.getAccountNumber() == accountNumber).findFirst().get();
		}catch(NoSuchElementException e){
			
			return null ;
		}
		
		
		}
	
	public void closeAccount(long accountNumber){
		Account acc = this.getAccount(accountNumber);
		if(acc != null){
			acc.setStatus(AccountStatus.CLOSED);
			System.out.println("Satus of account changed to CLOSED");
		}
	}
	
	public List<Account> getAll(){
		return new LinkedList<Account>(accounts);
	}
	
	public Set<Account> findByAccountHolder(String name){
		return accounts.stream().filter((x)->x.getAccountHolder().equalsIgnoreCase(name)).collect(Collectors.toSet());
	}
}
