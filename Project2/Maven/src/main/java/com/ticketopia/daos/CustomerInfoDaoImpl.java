package com.ticketopia.daos;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.UserType;
import com.ticketopia.util.HibernateUtil;

public class CustomerInfoDaoImpl implements CustomerInfoDao {
	@Override
	public CustomerInfo getCustomerByEmail(String email) {
		Session session = null;
		CustomerInfo customer = null;
		try
		{
			session = HibernateUtil.getSession();
			customer = (CustomerInfo)session.get(CustomerInfo.class, email);
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return customer;
	}
	
	@Override
	public boolean createCustomer(CustomerInfo customer) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(customer); //Returns the id of the fresh insert
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	@Override
	public boolean updateCustomerInfo(CustomerInfo customer, String email) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customer.getUserEmail());
			ci = customer;
			ci.setUserEmail(email);
			session.merge(ci);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<CustomerInfo> getCustomerInfo() {
		Session session = null;
		List<CustomerInfo> customers = null;
		
		try {			
			session = HibernateUtil.getSession();
			customers = (List<CustomerInfo>)session.createQuery("FROM CustomerInfo").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customers;
	}
	
	@Override
	public Boolean removeCustomerInfo(CustomerInfo customer) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customer.getUserEmail());
			session.delete(ci);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
}
