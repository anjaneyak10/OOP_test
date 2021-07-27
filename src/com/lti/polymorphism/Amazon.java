package com.lti.polymorphism;

public abstract class Amazon {
	private double  discount;
	
	protected Amazon() {
		System.out.println("Welcome");
		discount = 0.01;
	}
	abstract void purchase(double price);
	
	protected double amazonDiscount() {
		return discount;
	}
	
}
