package com.ticketopia.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory =
			new Configuration()
			.configure()
			.buildSessionFactory();
	
	public static Session getSession(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return sessionFactory.openSession();
		} catch (NoClassDefFoundError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
