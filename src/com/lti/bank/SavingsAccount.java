package com.lti.bank;

public class SavingsAccount extends Accounts {
	
	private int minBal=5000;;
	
	
	
	
	
	public SavingsAccount(String accNo, double accBal, String accPass, String bankName) {
		super(accNo, accBal, accPass, bankName);
	}



	public void display() {
		// TODO Auto-generated method stub
		super.display();
		System.out.println("Min balance is \nRs"+minBal);
	}



	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
		System.out.println("overdraft amount left = "+(super.getAccBal()-amount));
		
	}
	
	
	
}
