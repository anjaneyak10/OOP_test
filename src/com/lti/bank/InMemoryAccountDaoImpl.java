package com.lti.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InMemoryAccountDaoImpl implements AccountDAO {

	
	List<Accounts> acc = new ArrayList<Accounts>();
	Scanner sc= new Scanner(System.in);
	
	@Override
	public boolean addAnAccount(Accounts account) {
		// TODO Auto-generated method stub
		
		acc.add(account);
		
		
		return false;
	}

	@Override
	public  void withdraw(String accountNumber, double amount) {
		// TODO Auto-generated method stub
		
		Accounts acc2 = getAccountDetails(accountNumber);
		if(acc2==null) {
			System.out.println("Wrong acc no");
			return;
		}
		if(acc2.getAccBal()<amount) {
			try {
				throw new InsufficientFundException("Sorry!! not enough balance");
				}
				catch(InsufficientFundException e){
					System.out.println(e.getMessage());
				}
			return;
		}
		acc2.setAccBal(acc2.getAccBal()-amount);
		acc2.display();

	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Enter Acc Number");
		String accNo3 = sc.next();
		
		Accounts acc2 = getAccountDetails(accNo3);
		if(acc2==null) {
			System.out.println("Wrong acc number");
			return 0;
		}
		
		
		System.out.println("Acc balance = Rs."+acc2.getAccBal());
		return 0;
	
	}

	@Override
	public void changePassword(String accNo4, String oldp, String newp) {
		// TODO Auto-generated method stub
		Accounts acc2 = getAccountDetails(accNo4);
		if(acc2==null) {
			System.out.println("Wrong acc number");
			return;
		}
		if(!acc2.getAccPass().equals(oldp)) {
			System.out.println("Wrong pass");
			return;
		}
		acc2.setAccPass(newp);

	}

	@Override
	public  List<Accounts> viewAllAccounts() {
		// TODO Auto-generated method stub
		
		return acc;
	}

	@Override
	public  Accounts getAccountDetails(String accountNumber) {
		// TODO Auto-generated method stub
		for(Accounts a :acc) {
			if(a.getAccNo().equals(accountNumber))
				return a;
		}
		return null;
		
		
	}

}
