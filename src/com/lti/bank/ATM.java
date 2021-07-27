package com.lti.bank;

public interface ATM {
	void withdraw(int accountNumber,double amount);
	boolean changePassword(int accountNumber,String oldPassword,String newPassword);
	double checkBalance();

}
