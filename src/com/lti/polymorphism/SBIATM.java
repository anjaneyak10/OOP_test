package com.lti.polymorphism;

public class SBIATM implements ATM {
	
	private double  bal = 10000;
	private double amt;
	
	
	public void withdraw(double amt) {
		
		this.amt = amt;
		System.out.println("amt withdrawn from SBI "+amt);
	}
	 
	
	
	public double checkBalance() {
		return bal-amt;
		 
	 }

}
