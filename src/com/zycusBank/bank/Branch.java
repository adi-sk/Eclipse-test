package com.zycusBank.bank;

public class Branch {
	private String branchCode;
	private String branchName;
	private String bankCode;

	public Branch(String branchCode, String bankCode, String branchName) {
		super();
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.bankCode = bankCode;
	}

	public Branch() {

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
		this.branchName = branchName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", branchName=" + branchName + ", bankCode=" + bankCode + "]";
	}

}
