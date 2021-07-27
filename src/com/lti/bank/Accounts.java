package com.lti.bank;

import java.util.Scanner;

public abstract class Accounts {
	private String accNo;
	private double accBal;
	private String accPass;
	private String bankName;
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public double getAccBal() {
		return accBal;
	}
	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}
	public String getAccPass() {
		return accPass;
	}
	public void setAccPass(String accPass) {
		this.accPass = accPass;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
	 this.bankName = bankName;
	}
	public Accounts(String accNo, double accBal, String accPass,String bankName) {
		super();
		this.accNo = accNo;
		this.accBal = accBal;
		this.accPass = accPass;
		this.bankName=bankName;
	}
	public Accounts() {
		super();
	}
	
	public void display() {
		System.out.println("Acc no is\n"+accNo+"\nAcc bal is\nRs."+accBal+"\nBank Name is\n"+bankName);
	}
	
	public abstract void withdraw(double amount);
	

}
