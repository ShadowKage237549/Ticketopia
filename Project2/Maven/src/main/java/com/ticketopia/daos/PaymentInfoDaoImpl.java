package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.util.HibernateUtil;

public class PaymentInfoDaoImpl implements PaymentInfoDao{
	private final static Logger logger = Logger.getLogger(PaymentInfoDaoImpl.class);
	
	// Inserts a new paymentinfo object
	@Override
	public boolean insertNewPaymentInfo(PaymentInfo paymentInfo) {
		logger.info("insertNewPaymentInfo called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(paymentInfo); //Returns the id of the fresh insert
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
	
	// updates a payment object
	@Override
	public boolean updatePaymentInfo(PaymentInfo payment, CustomerInfo customer) {
		logger.info("updatePaymentInfo called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("getting paymentinfo object");
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, payment.getCustomerInfo().getUserEmail());
			pi = payment;
			pi.setCustomerInfo(customer);
			session.merge(pi); //Returns the id of the fresh insert
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

	// removes a payment method
	@Override
	public boolean removePaymentInfo(PaymentInfo paymentInfo) {
		logger.info("removePaymentInfo called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("getting payment object");
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, paymentInfo.getCustomerInfo().getUserEmail());
			session.delete(pi);
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
	
	// gets a list of all payments
	@Override
	public List<PaymentInfo> getPayments() {
		logger.info("getPayments called");
		Session session = null;
		List<PaymentInfo> payments = null;
		
		try {			
			logger.info("About to hit db");
			session = HibernateUtil.getSession();
			payments = (List<PaymentInfo>)session.createQuery("FROM PaymentInfo").list();
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("returning payments");
		return payments;
	}

}
