package com.lti.exception;

public class ExceptionMain2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("start");
		
		
		int num[]= {11};
		int num2[]= {1,2,4};
		try {
			System.out.println(num[0]);
			System.out.println(num2[2]);
			int i = 10/0;
			
		} catch (NullPointerException e) {
			
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		finally {
			System.out.println("finally ");
		}
		
		
		
		System.out.println("end");
	}

}
