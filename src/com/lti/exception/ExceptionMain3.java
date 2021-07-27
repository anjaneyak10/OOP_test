package com.lti.exception;

import java.util.Scanner;

public class ExceptionMain3 {
	public static void main(String[] args) throws NegetiveAgeException {
		// TODO Auto-generated method stub
		
		System.out.println("start");
		
		
		int num[]= {11};
		int num2[]= {1,2,4};
		try {
			System.out.println(num[0]);
			System.out.println(num2[2]);
			int i = 10/0;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		
		System.out.println("enter your age");
		Scanner sc =  new Scanner(System.in);
		int age = sc.nextInt();
		if(age<0) {
			try {
			throw new NegetiveAgeException("Age can't be negetive");
			}
			catch(NegetiveAgeException e){
				System.out.println(e.getMessage());
			}
		}
		else
			System.out.println(age+" y.o");
		
		
		System.out.println("end");
	}

}
