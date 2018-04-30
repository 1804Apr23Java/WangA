package com.revature.java.challengeone;

public class Basket {
	private Object[] basket;
	private static final int SIZE = 20;
	private int production;
	private int consumption;
	
	public Basket() {
		this.basket = new Object[Basket.SIZE];
	}
	
	public synchronized void insert() {
		if (production - consumption == 0) {
			production = (int) Math.random() * 20;
			for (int x = 0; x < production; x++) {
				basket[x] = "Item" + x;
			}
			System.out.println(production + " items produced.");
			System.out.println("Basket contains " + (production - consumption) + " items.");
		}
	}
	
	public synchronized void delete() {
		while (production - consumption > 0) {
			consumption = (int) Math.random() * 20;
			for (int x = consumption; x > 0; x--) {
				basket[x] = null;
			}
			System.out.println(consumption + " items consumed.");
			System.out.println("Basket contains " + (production - consumption) + " items.");
		}
	}
}
