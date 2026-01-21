package com.wipro.bams.main;

import java.util.ArrayList; 
import com.wipro.bams.entity.*; 
import com.wipro.bams.service.BankService; 
import com.wipro.bams.util.*; 

public class Main {
	public static void main(String[] args) { 
		ArrayList<Customer> customers = new ArrayList<>(); 
		customers.add(new Customer("C001", "Rahul Sharma", "9876543210")); 
		customers.add(new Customer("C002", "Priya Verma", "9123456780")); 
		ArrayList<Account> accounts = new ArrayList<>(); 
		accounts.add(new Account("A001", "C001", "Savings", 5000.0)); 
		accounts.add(new Account("A002", "C002", "Current", 10000.0)); 
		 
		        ArrayList<Transaction> transactions = new ArrayList<>(); 
		 
		        BankService service = new BankService(customers, accounts, transactions); 
		 
		        try { 
		 
		            service.validateCustomer("C001"); 
		 
		            Transaction t1 = service.deposit("A001", 2000.0); 
		            System.out.println("Deposit Successful! ID: " + t1.getTransactionId()); 
		 
		            Transaction t2 = service.withdraw("A001", 1500.0); 
		            System.out.println("Withdrawal Successful! ID: " + t2.getTransactionId()); 
		 
		            System.out.println("\n--- Transaction History for A001 ---"); 
		            service.printTransactionHistory("A001"); 
		 
		        } catch (InvalidCustomerException ice) { 
		            System.out.println(ice.toString()); 
		        } catch (InsufficientBalanceException ibe) { 
		            System.out.println(ibe.toString()); 
		        } catch (TransactionException te) { 
		            System.out.println(te.toString()); 
		        } catch (Exception ex) { 
		            System.out.println("Unexpected Error: " + ex); 
		        }

	}
}
