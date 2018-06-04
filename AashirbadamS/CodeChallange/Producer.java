package CodeChallange;

public class Producer {
	
	private String wine;
	private Integer noOfWine;
	
	public Producer( int noOfWine) {
		this.wine = wine;
		this.noOfWine = noOfWine;
	}


	public String getWine() {
		return wine;
	}
	public void setWine(String wine) {
		this.wine = wine;
	}
	public int getNoOfWine() {
		return noOfWine;
	}
	public void setNoOfWine(int noOfWine) {
		this.noOfWine = noOfWine;
	}
	@Override
	public String toString() {
		return "Producer [wine=" + wine + ", noOfWine=" + noOfWine + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + noOfWine;
		result = prime * result + ((wine == null) ? 0 : wine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producer other = (Producer) obj;
		if (noOfWine != other.noOfWine)
			return false;
		if (wine == null) {
			if (other.wine != null)
				return false;
		} else if (!wine.equals(other.wine))
			return false;
		return true;
	}

}
