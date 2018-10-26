package com.ticketopia.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionFactory;

	public static Session getSession() {
		if (sessionFactory != null)
			sessionFactory.close();
		sessionFactory = new Configuration().configure().buildSessionFactory();

		return sessionFactory.openSession();
	}
}
