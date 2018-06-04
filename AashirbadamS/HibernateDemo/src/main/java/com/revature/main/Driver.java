package com.revature.main;

import java.util.List;

import org.hibernate.Session;

import com.revature.Util.HibernateUtil;
import com.revature.beans.Commenter;
import com.revature.dao.CommenterDao;
import com.revature.dao.CommenterDaoImpl;

public class Driver {

	public static void main(String[] args) {

		
		 Session s = HibernateUtil.getSession();
		 System.out.println(s.getStatistics()); 
		 System.out.println(s.isOpen());
		 s.close(); 
		 System.out.println(s.isOpen());
		 
		
/*
		CommenterDao dc = new CommenterDaoImpl();
		Commenter c1 = new Commenter("Angela", "Wang", "a.wang@gmail.com");
		Commenter c2 = new Commenter("Kevin", "Magno", "k.magno@gmail.com");
		Commenter c3 = new Commenter("Shivam", "Aashir", "s.aashir@gmail.com");

		c1.setCommenterId(dc.addCommenter(c1));
		c2.setCommenterId(dc.addCommenter(c2));
		c3.setCommenterId(dc.addCommenter(c3));

		List<Commenter> cm = dc.getCommenter();

		for (Commenter s : cm) {
			System.out.println(s);

		}*/

	}
}
