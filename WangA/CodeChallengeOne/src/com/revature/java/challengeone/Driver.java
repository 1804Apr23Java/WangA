package com.revature.java.challengeone;

public class Driver {
	public static void main(String[] args) throws InterruptedException {
		Basket basket = new Basket();
		Producer producer = new Producer(basket);
		Consumer consumer = new Consumer(basket);
		producer.run();
		consumer.run();
		producer.join();
		consumer.join();
	}
}
