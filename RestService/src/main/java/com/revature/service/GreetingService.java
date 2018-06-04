package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Greeting;
import com.revature.repository.GreetingDao;

@Service(value="flashcardService")
public class GreetingService {
	
	@Autowired
	GreetingDao gr;

	public List<Greeting> getGreetings() {
		List<Greeting> greetings = gr.getGreetings();
				/*new ArrayList<Flashcard>();
		Flashcard f = new Flashcard(3,"Where do you stand if you're cold?", "In the corner, it's 90 degrees.",
				new Category(2, "meteorology"));
		Flashcard f2 = new Flashcard(75,"How much wood could a woodchuck chuck?", "Can a woodchuck chuck wood?",
				new Category(2, "meteorology"));
		flashcards.add(f);
		flashcards.add(f2);*/
		return greetings;
	}

	public void addGreeting(Greeting greeting) {
		
		gr.persistGreeting(greeting);
		
	}
}
