package com.revature.compare;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

	@Override
	public int compare(Player arg0, Player arg1) {
		return(arg0.getRanking() - arg1.getRanking());
	}



}
