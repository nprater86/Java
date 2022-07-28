package com.nprater86.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount test = new BankAccount();
		
		System.out.println(test.totalFunds());
		
		//test deposit
		test.deposit("checking", 500000);
		test.deposit("savings", 1000000);
		
		System.out.println(test.getCheckingBalance());
		System.out.println(test.getSavingsBalance());
		System.out.println(test.totalFunds());
		
		//test withdraw
		test.withdraw("checking", 250000);	
		test.withdraw("savings", 250000);
		
		System.out.println(test.getCheckingBalance());
		System.out.println(test.getSavingsBalance());
		System.out.println(test.totalFunds());
		
		//test static attribute
		BankAccount test2 = new BankAccount();
		BankAccount test3 = new BankAccount();
		BankAccount test4 = new BankAccount();
		
		System.out.println(BankAccount.getNumOfAccounts());		
	}

}
