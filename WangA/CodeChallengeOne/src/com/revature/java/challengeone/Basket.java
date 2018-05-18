package com.revature.java.challengeone;

public class Basket {
	private String[] basket;
	private static final int SIZE = 5;
	private int production;
	private int consumption;
	private int itemCount = 0;
	
	public Basket() {
		this.basket = new String[Basket.SIZE];
	}
	
	public synchronized void insert() throws InterruptedException {
		while(true) {	
			synchronized (this) {
			while (itemCount == SIZE) {
				wait();
			}
			production = (int) Math.random() * 5 + 1;
			for (int x = 0; x < production; x++) {
				basket[x] = "Item" + x;
				}
				itemCount += production;
				System.out.println(production + " items produced.");
				System.out.println("Basket contains " + itemCount + " items.");
			}
		}
	}
	
	public synchronized void delete() throws InterruptedException {
		while(true) {
		synchronized (this) {
			while (itemCount == 0) {
				wait();
			}
			consumption = (int) Math.random() * 5 + 1;
			for (int x = consumption; x > 0; x--) {
				basket[x] = null;
				}
			itemCount -= consumption;
			System.out.println(consumption + " items consumed.");
			System.out.println("Basket contains " + itemCount + " items.");
			}
		}
	}
}
