package com.lti.polymorphism;

import java.util.Scanner;

public class IntMain {
	public static void main(String []args) {
		System.out.println("select card 1.icici 2.SBI ");
		int ch = new Scanner(System.in).nextInt();
		ATM atm =null;
		if(ch==1) {
			atm = new IciciATM();
		}
		if(ch==2) {
			atm=new SBIATM();
		}
		atm.withdraw(1000);
		atm.checkBalance();
		
	}
}
