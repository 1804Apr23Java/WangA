package House;

import java.util.List;

public class Foundation implements Buildable {

	public Foundation(int numWood, int numSteel, int numDays) {
		super();
		this.numWood = numWood;
		this.numSteel = numSteel;
		this.numDays = numDays;
	}

	private int numWood;
	private int numSteel;
	private int numDays;
	
	public int getNumWood() {
		return numWood;
	}

	public void setNumWood(int numWood) {
		this.numWood = numWood;
	}

	public int getNumSteel() {
		return numSteel;
	}

	public void setNumSteel(int numSteel) {
		this.numSteel = numSteel;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	@Override
	public void build(Budget b, List<Worker> workers) {
		System.out.println("Building Foundation");
		b.spendMoney(numWood*COST_OF_WOOD + numSteel*COST_OF_STEEL);
		for (int i = 0; i < numDays; i++) {
			for (Worker w: workers) {
				w.work(b);
			}
		}
	}

}