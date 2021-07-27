package com.lti.polymorphism;

public class Seller1 extends Amazon {

	protected Seller1() {
		super();
	}
	

	@Override
	void purchase(double price) {
		// TODO Auto-generated method stub
		double priceToBePaid = price- price*amazonDiscount();
		System.out.println("Amount to be paid is "+priceToBePaid);
		

	}

}
