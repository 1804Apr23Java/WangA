package House;

public abstract class Worker {
	
	public Worker(String name, double hourlyPay) {
		super();
		this.name = name;
		this.hourlyPay = hourlyPay;
	}

	String name;
	protected double hourlyPay;

	public double getSalary() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	abstract void work(Budget b);
}