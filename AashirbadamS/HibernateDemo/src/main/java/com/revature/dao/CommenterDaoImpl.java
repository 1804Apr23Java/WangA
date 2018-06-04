package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.Util.HibernateUtil;
import com.revature.beans.Commenter;

public class CommenterDaoImpl implements CommenterDao {

	@Override
	public List<Commenter> getCommenter() {
		// TODO Auto-generated method stub

		List<Commenter> commenter = new ArrayList<Commenter>();
		Session s = HibernateUtil.getSession();
		commenter = s.createQuery("from Commenter").list();
		s.close();
		return commenter;
	}

	@Override
	public int addCommenter(Commenter c) {
		// TODO Auto-generated method stub

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(c);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateCommenter(Commenter c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommenter(Commenter c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commenter getCommenterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
