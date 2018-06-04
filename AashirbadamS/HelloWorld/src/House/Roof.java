package House;

import java.util.List;

public class Roof extends Floors {

	private int numShingles;
	
	public Roof(int numWood, int numSteel, int numDays, int numShingles) {
		super(1, numWood, numSteel, numDays);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void build(Budget b, List<Worker> workers)
	{
		System.out.println("Working on roof.");
		super.build(b, workers);
		System.out.println("Putting shingles on roof");
		b.spendMoney(numShingles*10);
	}

}
