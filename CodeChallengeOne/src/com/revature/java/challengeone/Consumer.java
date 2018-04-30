package com.revature.java.challengeone;

public class Consumer extends Thread {
	private Basket basket;
	
	public Consumer(Basket basket) {
		super();
		this.basket = basket;
	}

	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			basket.delete();
		}
	}
}
