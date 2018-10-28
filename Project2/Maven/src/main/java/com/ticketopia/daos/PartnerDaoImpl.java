package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Partner;
import com.ticketopia.util.HibernateUtil;

public class PartnerDaoImpl implements PartnerDao {
	private final static Logger logger = Logger.getLogger(PartnerDaoImpl.class);
	
	// Creates a new partner object
	@Override
	public boolean insertNewPartner(Partner partner) {
		logger.info("insertNewPartner called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit the db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(partner);
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
	
	// Removes a partner
	@Override
	public boolean removePartnerById(Partner partner) {
		logger.info("removePartner called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("Getting partner object");
			Partner p = (Partner) session.get(Partner.class, partner.getPartnerId());
			session.delete(p);
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
	
	// updates a partner object
	@Override
	public boolean updatePartner(Partner partner) {
		logger.info("updatePartner called");
		Session session = null;
		Transaction tx = null;
		Partner p = null;
		
		try {
			logger.info("About to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("Getting partner object");
			p = (Partner) session.get(Partner.class, partner.getPartnerId());
			p = partner;
			session.merge(p);
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
	
	// Returns a list of all partners
	@Override
	public List<Partner> getAllPartner() {
		logger.info("getAllPartner called");
		Session session = null;
		List<Partner> partners = null;
		String hql;
		Query query;
		
		try {
			logger.info("About to hit db");
			session = HibernateUtil.getSession();
			hql = "FROM Partner";
			query = session.createQuery(hql);
			partners = query.list();
		} catch(HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Returning partners");
		return partners;
	}
}
