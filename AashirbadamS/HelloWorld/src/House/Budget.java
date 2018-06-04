package House;

public class Budget {

	private double money;
	private int loans;

	public Budget(double money) {
		this.money = money;
		this.loans = 0;
	}

	// public void budget() {
	// System.out.println("The amount of money the house owner want to invest");
	// }
	//
	// public void budget(double money) {
	// System.out.println("The amount of money Proposed");
	// }

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void spendMoney(double cost) {
		this.money -= cost;
		while (this.money < 0) {
			System.out.println("Ran out of money; taking out loan.");
			money += 1000;
			loans += 1;
		}
	}

	public int getLoans() {
		return loans;
	}

	public void setLoans(int loans) {
		this.loans = loans;
	}

}
