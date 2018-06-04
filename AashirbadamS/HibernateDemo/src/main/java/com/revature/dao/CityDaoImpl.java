package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.Util.HibernateUtil;
import com.revature.beans.City;
import com.revature.beans.Comment;

public class CityDaoImpl implements CityDao {

	@Override
	public List<City> getCity() {
		// TODO Auto-generated method stub
		List<City> cy = new ArrayList<>();
		Session s = HibernateUtil.getSession();
		cy = s.createQuery("from City").list();
		s.close();
		return cy;
	}

	@Override
	public Comment getCityId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCity(City c) {
		// TODO Auto-generated method stub

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(c);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateCity(City c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCity(City c) {
		// TODO Auto-generated method stub

	}

}
