package com.zycusBank.account;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BranchParent {
	public boolean openNewAccount(AccountType type,long balance,String accountHolder){
		return false;
	}
	
	public Account getAccount(long accountNumber){
		return null;
	}
	
	public void closeAccount(long accountNumber){
		
	}
	
	public List<Account> getAll(){
		return null;
	}
	
	public Set<Account> findByAccountHolder(String name){
	    return null;
	}
}
