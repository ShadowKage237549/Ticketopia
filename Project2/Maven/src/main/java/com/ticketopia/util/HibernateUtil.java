package com.ticketopia.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static Session getSession() throws ClassNotFoundException {
		SessionFactory sessionFactory = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory.openSession();
	}
}
