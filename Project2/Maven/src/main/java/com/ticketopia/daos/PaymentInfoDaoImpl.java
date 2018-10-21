package com.ticketopia.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	public boolean removePaymentInfoById(PaymentInfo paymentInfo, Integer id) {
		return false;
	}

	@Override
	public boolean updatePaymentInfo(PaymentInfo paymentInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}
