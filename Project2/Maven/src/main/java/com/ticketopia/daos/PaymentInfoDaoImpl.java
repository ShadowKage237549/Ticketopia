package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.util.HibernateUtil;

public class PaymentInfoDaoImpl implements PaymentInfoDao{

	@Override
	public boolean insertNewPaymentInfo(PaymentInfo paymentInfo) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(paymentInfo); //Returns the id of the fresh insert
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
	public boolean removePaymentInfo(PaymentInfo paymentInfo) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, paymentInfo.getCustomerInfo().getUserEmail());
			session.delete(pi);
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
	public boolean updatePaymentEmail(PaymentInfo payment, CustomerInfo customer) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, payment.getCustomerInfo().getUserEmail());
			pi.setCustomerInfo(customer);
			session.update(pi);
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
	public boolean updatePaymentCardNumber(PaymentInfo paymentInfo, Long cardNumber) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, paymentInfo.getCustomerInfo().getUserEmail());
			pi.setCardNumber(cardNumber);
			session.update(pi);
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
	public boolean updatePaymentSecurityCode(PaymentInfo paymentInfo, Integer securityCode) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, paymentInfo.getCustomerInfo().getUserEmail());
			pi.setSecurityCode(securityCode);
			session.update(pi);
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
	public boolean updatePaymentExpirationDate(PaymentInfo paymentInfo, String expirationDate) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, paymentInfo.getCustomerInfo().getUserEmail());
			pi.setExpirationDate(expirationDate);
			session.update(pi);
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
	public boolean updatePaymentBillingAddress(PaymentInfo paymentInfo, String address,
												String city, String state, Integer zip) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PaymentInfo pi = (PaymentInfo) session.get(PaymentInfo.class, paymentInfo.getCustomerInfo().getUserEmail());
			pi.setBillingAddress(address);
			pi.setBillingCity(city);
			pi.setBillingState(state);
			pi.setBillingZip(zip);
			session.update(pi);
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
	public List<PaymentInfo> getPayments() {
		Session session = null;
		List<PaymentInfo> payments = null;
		
		try {			
			session = HibernateUtil.getSession();
			payments = (List<PaymentInfo>)session.createQuery("FROM PaymentInfo").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return payments;
	}

}
