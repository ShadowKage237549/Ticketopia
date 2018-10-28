package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ticketopia.beans.UserType;
import com.ticketopia.util.HibernateUtil;

public class UserTypeDaoImpl implements UserTypeDao {
	private final static Logger logger = Logger.getLogger(UserTypeDaoImpl.class);
	@SuppressWarnings("unchecked")
	@Override
	public List<UserType> getUserTypes() {
		logger.info("getUserTypes called");
		Session session = null;
		List<UserType> userTypes = null;
		
		try {			
			logger.info("about to hit the db");
			session = HibernateUtil.getSession();
			userTypes = (List<UserType>)session.createQuery("FROM UserType").list();
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("returning userTypes");
		return userTypes;
	}
}
