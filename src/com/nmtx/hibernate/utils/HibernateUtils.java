package com.nmtx.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	
	static {
		Configuration config = new Configuration().configure();
		 sessionFactory = config.buildSessionFactory();
	}
	
	public static Session openSession() {
		Session session = sessionFactory.openSession();
		return session;
	}
	
	public static Session getCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

}
