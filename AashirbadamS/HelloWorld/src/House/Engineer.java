package House;

public class Engineer extends Worker{

	public Engineer(String name, double hourlyPay) {
		super(name, hourlyPay);
		// TODO Auto-generated constructor stub
	}

	public Engineer(String name) {
		super(name, 34);
		// TODO Auto-generated constructor stub
	}
	@Override
	void work(Budget b) {
		// TODO Auto-generated method stub
		System.out.println("Engineer " + super.getName() + " working today.");
		b.spendMoney(6*hourlyPay);
	}

}
