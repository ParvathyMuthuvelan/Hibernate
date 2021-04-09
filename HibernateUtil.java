package com.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;
	public static Session session = null;

	public static Session getSession() throws HibernateException {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		//System.out.println("factory="+sessionFactory);
		session = sessionFactory.openSession();
		return session;
	}
}
