package com.ticketopia.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	

	public static Session getSession() {
		SessionFactory sessionFactory = null;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory.openSession();
	}
}
