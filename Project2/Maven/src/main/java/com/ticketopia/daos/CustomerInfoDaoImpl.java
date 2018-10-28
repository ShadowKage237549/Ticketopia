package com.ticketopia.daos;



import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.UserType;
import com.ticketopia.util.HibernateUtil;

public class CustomerInfoDaoImpl implements CustomerInfoDao {
	private final static Logger logger = Logger.getLogger(CustomerInfoDaoImpl.class);
	
	// retrieves one customer from database based on email
	@Override
	public CustomerInfo getCustomerByEmail(String email) {
		logger.info("getCustomerByEmail called");
		Session session = null;
		CustomerInfo customer = null;
		
		try
		{
			logger.info("About to hit database");
			session = HibernateUtil.getSession();
			customer = (CustomerInfo)session.get(CustomerInfo.class, email);
		}catch(HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		}finally {
			session.close();
		}
		logger.info("Returning customer");
		return customer;
	}
	
	// Adds a new customer object to the database
	@Override
	public boolean createCustomer(CustomerInfo customer) {
		logger.info("createCustomer called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit the database");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		logger.info("Returning false");
		return false;
	}
	
	// Updates a customer object
	@Override
	public boolean updateCustomerInfo(CustomerInfo customer, String email) {
		logger.info("updateCustomerInfo called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit the database");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("Creating new customer object");
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customer.getUserEmail());
			ci = customer;
			ci.setUserEmail(email);
			session.merge(ci);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Returning false");
		return false;
	}

	// Retrieves all customers
	@Override
	public List<CustomerInfo> getCustomerInfo() {
		logger.info("getCustomerInfo called");
		Session session = null;
		List<CustomerInfo> customers = null;
		
		try {			
			logger.info("About to hit the database");
			session = HibernateUtil.getSession();
			customers = (List<CustomerInfo>)session.createQuery("FROM CustomerInfo").list();
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Returning customers");
		return customers;
	}
	
	// Removes a customer from the database
	@Override
	public Boolean removeCustomerInfo(CustomerInfo customer) {
		logger.info("removeCustomerInfo called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit the database");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("Getting customer object");
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customer.getUserEmail());
			session.delete(ci);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		logger.info("Returning false");
		return false;
	}
}
