package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Partner;
import com.ticketopia.util.HibernateUtil;

public class PartnerDaoImpl implements PartnerDao {
	@Override
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
	
	@Override
	public boolean removePartnerById(Partner partner) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Partner p = (Partner) session.get(Partner.class, partner.getPartnerId());
			session.delete(p);
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
	public boolean updatePartner(Partner partner) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(partner);
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
	public List<Partner> getAllPartner() {
		Session session = HibernateUtil.getSession();
		List<Partner> partners = null;
		String hql;
		Query query;
		
		try {
			hql = "FROM Partner";
			query = session.createQuery(hql);
			partners = query.list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return partners;
	}
}
