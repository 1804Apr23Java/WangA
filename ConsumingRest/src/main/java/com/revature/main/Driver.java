package com.revature.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Greeting;
import com.revature.client.GreetingClient;

public class Driver {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		GreetingClient gc = ac.getBean("greetingClient", GreetingClient.class);
		
		gc.setResourceUrl("http://localhost:8083/RestService");
		
		for (Greeting g : gc.getGreetings()) {
			System.out.println(g);
		}
		
		ac.close();
	}

}

