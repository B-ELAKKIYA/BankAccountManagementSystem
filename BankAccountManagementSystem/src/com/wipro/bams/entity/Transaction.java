package com.wipro.bams.entity;

public class Transaction {
	private String transactionId;
	private String accountId;
	private String transactionType;
	private double amount;
	private String date;
	
	public Transaction(String transactionId,String accountId,String transactionType,double amount,String date) {
		this.transactionId=transactionId;
		this.accountId=accountId;
		this.transactionType=transactionType;
		this.amount=amount;
		this.date=date;
		
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
