package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ticketopia.beans.UserType;
import com.ticketopia.util.HibernateUtil;

public class UserTypeDaoImpl implements UserTypeDao {
	@Override
	public List<UserType> getUserTypes() {
		Session session = null;
		List<UserType> userTypes = null;
		
		try {			
			session = HibernateUtil.getSession();
			userTypes = (List<UserType>)session.createQuery("FROM UserType").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userTypes;
	}
}
