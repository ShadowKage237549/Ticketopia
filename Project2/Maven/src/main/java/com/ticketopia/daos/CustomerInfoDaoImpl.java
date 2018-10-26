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
		} finally {
			session.close();
		}
	}
	
	@Override
	public boolean adjustUserRole(CustomerInfo customer, Integer newRole) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Query query;
		String hql = null;	
		UserType role = null;
		
		try {
			hql = "FROM UserType WHERE roleId=:id";
			query = session.createQuery(hql);
			query.setParameter("id", newRole);
			
			role = (UserType)query.uniqueResult();
			
			customer.setRole(role.getRoleId());
			
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
	public boolean changePassword(CustomerInfo customer, String newPassword) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			customer.setPassword(newPassword);
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
	public void applyPoints(CustomerInfo customer, Integer points) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			customer.setAccumulatedPoints(points);
			tx = session.beginTransaction();
			session.save(customer); //Returns the id of the fresh insert
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}


	@Override
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
