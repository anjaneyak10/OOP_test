package com.lti.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.exception.NegetiveAgeException;

public class AccountsMain {
	public static void main(String[] args) {
		
//		InMemoryAccountDaoImpl impl = new InMemoryAccountDaoImpl();
		AccountDaoImpl impl = new AccountDaoImpl();
		Scanner sc = new Scanner(System.in);
		int i = 1;
		Accounts acc2=null;
		while (i == 1) {
			System.out.println("1. Add an Account , \\n 2.Withdraw \\n \"\r\n"
					+ "					+ \"3.Check Balance t\\n 4.Change Password\\n "
					+ "5.View all accounts ,6.Search for an Account 7.end");
			int j = sc.nextInt();
			switch (j) {
			case 1:
				System.out.println("1.Savings Account 2.Current Account");
				int ch = sc.nextInt();
				System.out.println("Enter acc no , balance, password, bank name");
				String accNo = sc.next();
				double bal = sc.nextDouble();
				String pass = sc.next();
				String bName = sc.next();
				if(bal<0) {
					try {
						throw new InvalidAmountException("Balance can't be negetive");
						}
						catch(InvalidAmountException e){
							System.out.println(e.getMessage());
						}	
					break;
				}
				if(ch==1) {
					acc2 = new SavingsAccount(accNo,bal,pass,bName);
				}
				else {
					acc2 = new CurrentAccount(accNo,bal,pass,bName);
				}
				impl.addAnAccount(acc2);
				break;
			case 2:
				System.out.println("Enter Amount you want to withdraw , Account number");
				double wi =sc.nextDouble();
				String accNo1 = sc.next();
				impl.withdraw(accNo1, wi);
				
				
				break;
			case 3:
				impl.checkBalance();
				
				break;
			case 4:
				System.out.println("Enter Acc Number");
				String accNo4 = sc.next();
				System.out.println("Enter old password");
				String oldp = sc.next();
				System.out.println("Enter new password");
				String newp = sc.next();
				impl.changePassword(accNo4, oldp, newp);
				
				break;
			case 5:
				List<Accounts> ls= impl.viewAllAccounts();
				for(Accounts ac : ls) {
					System.out.println("Acc no = "+ ac.getAccNo()+"Acc Bal = "+ac.getAccBal()+"Bank Name"+ac.getBankName());
				}
				break;
			case 6:
				System.out.println("Enter Acc Number");
				String accNo2 = sc.next();
				acc2 = impl.getAccountDetails(accNo2);
				if(acc2==null) {
					System.out.println("Wrong acc number");
					break;
				}
				acc2.display();
				break;
			case 7:
				i=0;
				break;
			default:
				i=0;
				break;
				
			}
		}
	}

}
