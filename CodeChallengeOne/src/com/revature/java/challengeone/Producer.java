package com.revature.java.challengeone;

public class Producer extends Thread {
	private Basket basket;
	
	public Producer(Basket basket) {
		super();
		this.basket = basket;
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			basket.insert();
		}
	}
}
