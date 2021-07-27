package com.lti.exception;

import java.util.Scanner;

public class ExceptionMain {

	
	static int res = 0;
	static int[] arr = new int[] {10,20,30,40,50};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2,pos;
		System.out.println("main begins");
		Scanner sc= new Scanner(System.in);
		System.out.println("enter 2 numbers");
		num1= sc.nextInt();
		num2=sc.nextInt();
		System.out.println(divide(num1,num2));
		System.out.println("enter the position");
		pos=sc.nextInt();
		System.out.println("element is "+ getElement(pos));
		
		
		
		
		System.out.println("main Ends");
	}
	public static int divide(int n1, int n2) {
		try {
			res= n1/n2;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public static int getElement(int a) {
		try {
		return arr[a];
		}
		catch(Exception e ) {
			System.out.println(e.getMessage()+ " returning default 0");
		}
		return 0;
	}

}
