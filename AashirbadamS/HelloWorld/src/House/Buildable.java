package House;

import java.util.List;

public interface Buildable {
	void build(Budget b, List<Worker> w);
	
	public static final double COST_OF_STEEL = 49.99;
	public static final double COST_OF_WOOD = 14.99;
}
