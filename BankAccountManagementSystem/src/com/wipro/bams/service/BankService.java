package com.wipro.bams.service;

import java.util.ArrayList;
import java.util.Date;
import com.wipro.bams.entity.*;
import com.wipro.bams.util.*;

public class BankService {
	private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public BankService(ArrayList<Customer> customers,ArrayList<Account> accounts,ArrayList<Transaction> transactions) {
        this.customers = customers;
        this.accounts = accounts;
        this.transactions = transactions;
    }

    public boolean validateCustomer(String customerId) throws InvalidCustomerException {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        throw new InvalidCustomerException();
    }

    public Account getAccount(String accountId) {
        for (Account a : accounts) {
            if (a.getAccountId().equals(accountId)) {
                return a;
            }
        }
        return null;
    }

    public Transaction deposit(String accountId, double amount) throws TransactionException {
        if (amount <= 0)
            throw new TransactionException();

        Account acc = getAccount(accountId);
        acc.setBalance(acc.getBalance() + amount);

        Transaction t = new Transaction("T" + (transactions.size() + 1),
                accountId, "DEPOSIT",
                amount,new Date().toString());

        transactions.add(t);
        return t;
    }

    public Transaction withdraw(String accountId, double amount)
            throws InsufficientBalanceException, TransactionException {

        Account acc = getAccount(accountId);

        if (amount <= 0)
            throw new TransactionException();

        if (acc.getBalance() < amount)
            throw new InsufficientBalanceException();

        acc.setBalance(acc.getBalance() - amount);

        Transaction t = new Transaction("T" + (transactions.size() + 1),
                accountId, "WITHDRAW",
                amount,new Date().toString());

        transactions.add(t);
        return t;
    }

    public void printTransactionHistory(String accountId) {
        for (Transaction t : transactions) {
            if (t.getAccountId().equals(accountId)) {
                System.out.println(t.getTransactionType() +" | " + t.getAmount() +" | " + t.getDate());
            }
        }
    }

}
