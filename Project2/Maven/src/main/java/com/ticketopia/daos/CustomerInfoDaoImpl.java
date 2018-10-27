package com.ticketopia.daos;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.UserType;
import com.ticketopia.util.HibernateUtil;

public class CustomerInfoDaoImpl implements CustomerInfoDao {
	
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
	public boolean updateCustomerEmail(CustomerInfo customerInfo, String email) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setUserEmail(email);
			session.update(ci);
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
	
	@Override
	public boolean updateCustomerDisplayName(CustomerInfo customerInfo, String displayName) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setDisplayName(displayName);
			session.update(ci);
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
	
	@Override
	public boolean updateCustomerFName(CustomerInfo customerInfo, String fName) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setUserFName(fName);
			session.update(ci);
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
	
	@Override
	public boolean updateCustomerLName(CustomerInfo customerInfo, String lName) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setUserLName(lName);
			session.update(ci);
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
	
	@Override
	public boolean updateCustomerAccumulatedPoints(CustomerInfo customerInfo, Integer points) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setAccumulatedPoints(points);
			session.update(ci);
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
	
	@Override
	public boolean updateCustomerUserType(CustomerInfo customerInfo, UserType userType) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setRole(userType.getRoleId());
			session.update(ci);
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
	
	@Override
	public boolean updateCustomerAddress(CustomerInfo customerInfo, String address,
										String city, String state, Integer zip) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setUserAddress(address);
			ci.setUserCity(city);
			ci.setUserState(state);
			ci.setUserZip(zip);
			session.update(ci);
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
	
	@Override
	public boolean updateCustomerPassword(CustomerInfo customerInfo, String password) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			CustomerInfo ci = (CustomerInfo) session.get(CustomerInfo.class, customerInfo.getUserEmail());
			ci.setPassword(password);
			session.update(ci);
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
	
	public CustomerInfo getCustomerByEmail(String email) {
		Session session = null;
		CustomerInfo customer = null;
		Query query = null;
		String hql = "FROM CustomerInfo WHERE userEmail = :email";
		try
		{
			session = HibernateUtil.getSession();
			query = session.createQuery(hql);
			query.setParameter("email", email);
			List<CustomerInfo> list = query.list();
			session.close();
			if(list.size() > 0) {
				customer = list.get(0);
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		}
			

		System.out.println(customer);
		return customer;
	}
}
