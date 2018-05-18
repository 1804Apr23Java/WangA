package com.revature.java.jdbc;

public class OverdraftException extends Exception {
	public OverdraftException(String message) {
		System.out.println(message);
	}
}
