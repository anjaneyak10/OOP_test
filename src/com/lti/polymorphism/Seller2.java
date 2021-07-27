package com.lti.polymorphism;

public class Seller2 extends Amazon {

	protected Seller2() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	void purchase(double price) {
		// TODO Auto-generated method stub
		double priceToBePaid = price- price*(amazonDiscount()+s2discount());
		System.out.println("Amount to be paid is "+priceToBePaid);
		

	}
	
	private double s2discount() {
		return 0.02;
	}

}
