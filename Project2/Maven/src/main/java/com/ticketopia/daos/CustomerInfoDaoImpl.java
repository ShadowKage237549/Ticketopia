package com.ticketopia.daos;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.UserType;
import com.ticketopia.util.HibernateUtil;

public class CustomerInfoDaoImpl implements CustomerInfoDao {
	@Override
	public boolean createCustomer(CustomerInfo customer) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session =  HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(customer); //Returns the id of the fresh insert
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;

	}
	
	@Override
	public boolean adjustUserRole(CustomerInfo customer, Integer newRole) {
		Session session = null;
		Transaction tx = null;
		Query query;
		String hql = null;	
		UserType role = null;
		
		try {
			session = HibernateUtil.getSession();
			hql = "FROM UserType WHERE roleId=:id";
			query = session.createQuery(hql);
			query.setParameter("id", newRole);
			
			role = (UserType)query.uniqueResult();
			
			customer.setRole(role);
			
			tx = session.beginTransaction();
			session.save(customer); //Returns the id of the fresh insert
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public boolean changePassword(CustomerInfo customer, String newPassword) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			customer.setPassword(newPassword);
			tx = session.beginTransaction();
			session.save(customer); //Returns the id of the fresh insert
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public void applyPoints(CustomerInfo customer, Integer points) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			customer.setAccumulatedPoints(points);
			tx = session.beginTransaction();
			session.save(customer); //Returns the id of the fresh insert
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


	@Override
	public CustomerInfo getCustomerByEmail(String email) {
		Query query = null;
		Session session = null;
		String hql = "FROM CustomerInfo WHERE userEmail = :email";
		CustomerInfo customer = null;
		try
		{
			session = HibernateUtil.getSession();
			query = session.createQuery(hql);
			query.setParameter("email", email);
			customer = (CustomerInfo)query.uniqueResult();
		}catch(HibernateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		return customer;
	}
}
