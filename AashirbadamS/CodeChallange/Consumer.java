package CodeChallange;

public class Consumer {

	private String restaurent;
	private Integer noOfWineRequested;
	public String getRestaurent() {
		return restaurent;
	}
	public void setRestaurent(String restaurent) {
		this.restaurent = restaurent;
	}
	public int getNoOfWineRequested() {
		return noOfWineRequested;
	}
	public void setNoOfWineRequested(int noOfWineRequested) {
		this.noOfWineRequested = noOfWineRequested;
	}
	@Override
	public String toString() {
		return "Consumer [restaurent=" + restaurent + ", noOfWineRequested=" + noOfWineRequested + "]";
	}
	
}
