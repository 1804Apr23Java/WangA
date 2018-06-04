package House;

import java.util.List;

public class Plan {
	
	private List<Buildable> planParts;
	
	public Plan(List<Buildable> planParts) {
		super();
		this.planParts = planParts;
	}

	public void buildAll(Budget b, List<Worker> workers)
	{
		for(Buildable part : planParts)
		{
			part.build(b,  workers);
		}
	}

}
