package com.lti.bank;

import java.util.List;

public interface AccountDAO {
		boolean addAnAccount(Accounts account);
		void withdraw(String accountNumber,double amount);
		double  checkBalance();
		void changePassword(String accountNumber,String oldPassword,String newPassword);
		List<Accounts> viewAllAccounts();
		Accounts getAccountDetails(String accountNumber);

}
