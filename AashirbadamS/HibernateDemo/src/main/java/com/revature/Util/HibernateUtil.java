package com.revature.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
private static SessionFactory sessionFactory;
	
	private static SessionFactory getSessionFactory(String filename) {
		
		if (HibernateUtil.sessionFactory == null) {
			Configuration c = new Configuration().configure(filename);
			c.setProperty("Hibernate.connection.username", System.getenv("username_database"));
			c.setProperty("Hibernate.connection.password", System.getenv("db_password_banking"));
			c.setProperty("Hibernate.connection.url", System.getenv("banking2_url"));
			
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			HibernateUtil.sessionFactory = c.buildSessionFactory(sr);
		}
		return HibernateUtil.sessionFactory;
		
	}
	
	public static Session getSession() {
		
		return getSessionFactory("hibernate.cfg.xml").openSession();
		
	}

}
