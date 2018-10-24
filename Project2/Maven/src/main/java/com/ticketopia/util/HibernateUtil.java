package com.ticketopia.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	

	public static Session getSession() {
		try {
			System.out.println("failed");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("failed");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("failed");
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
