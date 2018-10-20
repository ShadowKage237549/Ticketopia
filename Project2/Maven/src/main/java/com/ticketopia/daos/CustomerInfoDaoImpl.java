package com.ticketopia.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.UserRoles;
import com.ticketopia.util.HibernateUtil;

public class CustomerInfoDaoImpl implements CustomerInfoDao {
	public boolean createCustomer(CustomerInfo customer) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(customer); //Returns the id of the fresh insert
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	public boolean createPaymentMethod(String email, 
			Integer cardNumber,
			Integer securityCode,
			String expirationDate,
			String billingAddress,
			String billingCity,
			String billingState,
			Integer billingZip) {
		return false;
	}
	
	public boolean adjustUserRole(String email, UserRoles role) {
		return false;
	}
	
	public boolean changePassword(String email, String oldPassword) {
		return false;
	}
	
	public boolean removePaymentMethod(String email, UserRoles role) {
		return false;
	}
	
	public void applyPoints(Double points) {
		
	}
}
