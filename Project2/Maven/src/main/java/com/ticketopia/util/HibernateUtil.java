package com.ticketopia.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	

	public static Session getSession() {
		SessionFactory sessionFactory = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return sessionFactory.openSession();
	}
}
