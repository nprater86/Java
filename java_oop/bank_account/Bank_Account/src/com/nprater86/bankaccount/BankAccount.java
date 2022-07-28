package com.nprater86.bankaccount;

public class BankAccount {
	private double checkingBalance = 0;
	private double savingsBalance = 0;
	private static int numOfAccounts = 0;
	private static int totalAmountStored = 0;
	
	public BankAccount() {
		numOfAccounts++;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	public static int getNumOfAccounts() {
		return numOfAccounts;
	}
	
	public BankAccount deposit(String accountType, double amount) {
		if(accountType.toLowerCase() == "checking") {
			checkingBalance += amount;
			totalAmountStored += amount;
			return this;
		} else if(accountType.toLowerCase() == "savings") {
			savingsBalance += amount;
			totalAmountStored += amount;
			return this;
		} else {
			System.out.println("Invalid account type.");
			return this;
		}
	}
	
	public BankAccount withdraw(String accountType, double amount) {
		if(accountType.toLowerCase() == "checking") {
			checkingBalance -= amount;
			totalAmountStored -= amount;
			return this;
		} else if(accountType.toLowerCase() == "savings") {
			savingsBalance -= amount;
			totalAmountStored -= amount;
			return this;
		} else {
			System.out.println("Invalid account type.");
			return this;
		}
	}
	
	public double totalFunds() {
		return checkingBalance + savingsBalance;
	}
}
