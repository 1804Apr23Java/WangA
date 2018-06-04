package com.revature.calc;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double number1;
		double number2;
		String operation;
		
		Math m= new Math();		
		Scanner sc= new Scanner(System.in);
		System.out.println("Input First Number");		
		number1=sc.nextDouble();
		System.out.println("Input Second Number");	
		number2=sc.nextDouble();
		sc.close();
		System.out.println("Input Operation");
		Scanner op = new Scanner(System.in);
		operation=op.next();
		op.close();
		if(operation =="+") {
			m.add(number1, number2);
		}
		if(operation =="-") {
			m.subtract(number1, number2);
		}
	
		if(operation =="*") {
			m.multiply(number1, number2);
		}
		if(operation =="/") {
			m.divide(number1, number2);
		}

	}

}
