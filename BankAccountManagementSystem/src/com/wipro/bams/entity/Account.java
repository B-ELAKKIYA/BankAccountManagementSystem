package com.wipro.bams.entity;

public class Account {
	 private String accountId ;
	 private String customerId;
	 private String accountType;
	 private double balance;
	 
	 public Account(String accountId,String customerId,String accountType,double balance) {
		 this.accountId=accountId;
		 this.customerId=customerId;
		 this.accountType=accountType;
		 this.balance=balance;
	 }

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	 

}
