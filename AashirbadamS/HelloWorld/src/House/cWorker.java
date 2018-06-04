package House;

public class cWorker extends Worker {

	public cWorker(String name, double hourlyPay) {
		super(name, hourlyPay);
		// TODO Auto-generated constructor stub
	}

	@Override
	void work(Budget b) {
		// TODO Auto-generated method stub
		System.out.println("Construction worker " + super.getName() + " working today.");
		b.spendMoney(8*hourlyPay);
	}

}
