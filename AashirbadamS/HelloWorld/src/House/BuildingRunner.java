package House;

import java.util.ArrayList;
import java.util.List;

public class BuildingRunner {
	
	public static void main (String[] args) {
		
		Budget b = new Budget(240000);
		List <Buildable> parts = new ArrayList<Buildable>();
		parts.add(new Foundation(500, 1000, 7));
		parts.add(new Floors(3, 700, 700, 4));
		parts.add(new Roof(500, 500, 2, 100));
		
		List <Worker> workers = new ArrayList<Worker>();
		workers.add(new Engineer("Bob", 34.76));
		workers.add(new Engineer("Adam"));
		workers.add(new cWorker("Jim", 2.34));
		workers.add(new cWorker("Carrie", 16.92));
		workers.add(new cWorker("Mike", 19.56));
		
		Plan p = new Plan(parts);
		
		p.buildAll(b, workers);
		
		System.out.printf("Remaining money: $%.2f\n", b.getMoney());
		System.out.printf("Loans taken: %d", b.getLoans());
	}

}
