package CodeChallange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Basket capacity =6
		// if the restaurant consume more than 10 bottle
		// producer need to add the wine bottle;
		Producer p = new Producer(10);
		// Thread this for consumer
		// Thread this for Producer

		// shared List
		List<Integer> Basket = new ArrayList< Integer>();
		while(Basket.size()<6)
			p.setNoOfWine(10);;
			System.out.println(Basket.toString());
		}

	}




