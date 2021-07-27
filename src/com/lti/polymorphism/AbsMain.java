package com.lti.polymorphism;

import java.util.Scanner;

public class AbsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Amazon amazon=null;
		System.out.println("1.seller1 2.seller2");
		int ch = new Scanner(System.in).nextInt();
		
		if(ch==1) {
			amazon = new Seller1();
		}
		if(ch==2) {
			amazon=new Seller2();
		}
		amazon.purchase(5000);
	}

}
