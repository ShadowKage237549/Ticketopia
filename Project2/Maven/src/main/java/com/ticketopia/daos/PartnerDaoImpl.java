package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Partner;
import com.ticketopia.util.HibernateUtil;

public class PartnerDaoImpl implements PartnerDao {
	
	public boolean insertNewPartner(Partner partner) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(partner);
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
	
	public boolean removePartnerById(Partner partner) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(partner);
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
	
	public boolean updatePartner(Partner partner) {
		return false;
	}
	
	public List<Partner> getAllPartner() {
		List<Partner> partners = null;
		return partners;
	}
}
