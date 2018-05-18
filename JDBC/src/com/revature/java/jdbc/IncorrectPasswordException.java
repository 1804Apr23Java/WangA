package com.revature.java.jdbc;

public class IncorrectPasswordException extends Exception {
	public IncorrectPasswordException(String message) {
		System.out.println(message);
	}
}
