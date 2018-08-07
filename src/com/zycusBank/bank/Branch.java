package com.zycusBank.bank;

public class Branch{
	private String branchCode;
	private String branchName;
	public Branch(String branchCode, String branchName) {
		super();
		this.branchCode = branchCode;
		this.branchName= branchName;
	}
	
	public Branch(){
		
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName= branchName;
	}
	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", branchName=" + branchName + "]";
	}
	
	
	
	
	
}
