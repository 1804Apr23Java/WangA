package com.revature.compare;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

	public static void main(String[] args) {

		List<Player> footballTeam = new ArrayList<>();
		
		PlayerComparator pc = new PlayerComparator ();

		Player p1 = new Player(59, "Ronaldo", 28);
		Player p2 = new Player(31, "Salah", 24);
		Player p3 = new Player(61, "Messi", 41);

		footballTeam.add(p1);
		footballTeam.add(p2);
		footballTeam.add(p3);

		
		//Collections.sort(footballTeam, pc);//This method is for the comparator
		Collections.sort(footballTeam); //This method is for the comparable 
		System.out.println(footballTeam);
/*		for (Player p : footballTeam) {
			//Collections.sort(footballTeam);
			System.out.println(p);

		}*/
		funWithReflection();
	}
	
	public static void funWithReflection() {
		try {
			Class glass = Class.forName("com.revature.compare.Player");
			System.out.println(glass.getName());
			Field[] fields = glass.getDeclaredFields();
			for (Field f1:fields ){
				System.out.println(f1);
			}
			Player p5 =(Player) glass.newInstance();
			Field ranking = glass.getDeclaredField("ranking");
			ranking.setAccessible(true);
			ranking.set(p5, "Ramos");
			System.out.println(p5);
			
			
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
