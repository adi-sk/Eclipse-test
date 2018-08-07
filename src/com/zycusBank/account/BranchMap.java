package com.zycusBank.account;

import java.util.*;
import java.util.stream.Collectors;

public class BranchMap extends BranchParent {
	public static long branchCode = System.currentTimeMillis();
	private static long ACC_NO_GENERATOR = 0;
	Map<Long,Account> accounts = new HashMap<>();
	
	public boolean openNewAccount(AccountType type,long balance,String accountHolder){
		Account account = new Account(ACC_NO_GENERATOR,branchCode,accountHolder,type,balance,AccountStatus.ACTIVE);
		
		if(accounts.put(ACC_NO_GENERATOR, account) == null){
			System.out.println("New Account Added");
			ACC_NO_GENERATOR++;
			return true;
		}
		return false;
		
	}
	
	public Account getAccount(long accountNumber){
		return accounts.get(accountNumber);
	}
	
	public void closeAccount(long accountNumber){
		
		Account acc = this.getAccount(accountNumber);
		if(acc != null){
			acc.setStatus(AccountStatus.CLOSED);
		}
		else{
			System.out.println("Entered account no. is not valid");
		}
	}
	
	public List<Account> getAll(){
		return new LinkedList<Account>(accounts.values());
	}
	
	public Set<Account> findByAccountHolder(String name){
		return accounts.values().stream().filter((x)->x.getAccountHolder().equalsIgnoreCase(name)).collect(Collectors.toSet());
	}
	
}
