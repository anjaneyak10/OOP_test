package com.lti.bank;

public class CurrentAccount extends Accounts {

	
	private double overdraftLimitAmount=10000;
	
	
	
	
	public CurrentAccount(String accNo, double accBal, String accPass, String bankName) {
		super(accNo, accBal, accPass, bankName);
		this.overdraftLimitAmount=accBal*1.5;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display();
		System.out.println("Maximum Overdraft Limit Amount  \nRs"+overdraftLimitAmount);
	}
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
		System.out.println("overdraft amount left = "+(overdraftLimitAmount-amount));
		
	}
}
