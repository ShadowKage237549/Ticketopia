package com.ticketopia.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	

	public static Session getSession() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory.openSession();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
