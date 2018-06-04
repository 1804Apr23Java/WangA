package House;

import java.util.List;

public class Floors implements Buildable {

	private int numFloors;

	// materials per floor
	private int numWood;
	private int numSteel;
	private int numDays;

	public Floors(int numFloors, int numWood, int numSteel, int numDays) {
		super();
		this.numFloors = numFloors;
		this.numWood = numWood;
		this.numSteel = numSteel;
		this.numDays = numDays;
	}

	@Override
	public void build(Budget b, List<Worker> workers) {
		for (int j = 0; j < numFloors; j++) {
			System.out.println("Building Floor " + (j + 1));
			b.spendMoney(numWood * COST_OF_WOOD + numSteel * COST_OF_STEEL);
			for (int i = 0; i < numDays; i++) {
				for (Worker w : workers) {
					w.work(b);
				}
			}
		}
	}

}
