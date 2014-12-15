package org.jesus.meslap.worship.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.jesus.meslap.entity.Worship;
import org.jesus.meslap.worship.dao.WorshipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorshipDAOImpl implements WorshipDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		if(session == null)
			session = sessionFactory.openSession();
		return session;
	}
	
	public void merge(Worship worship) {
		getSession().merge(worship);
	}
	
	public void save(Worship worship) {
		getSession().saveOrUpdate(worship);
	}
	
	public List<Worship> getWorships(Integer fRow, Integer pageSize){
		Criteria crit = getSession().createCriteria(Worship.class);
		crit.addOrder(Order.desc("id"))
		.setFirstResult(fRow)
		.setMaxResults(pageSize);
		return crit.list();
	}

	public Worship getWorship(Integer id) {
		return (Worship) getSession().get(Worship.class, id);
	}

	public void delete(Integer id) {
		Worship w = getWorship(id);
		getSession().delete(w);
	}

	public Integer getWorshipCount() {
		Criteria crit = getSession().createCriteria(Worship.class);
			crit.setProjection(Projections.rowCount());
		Long count = (Long)crit.uniqueResult();
		return count.intValue();
	}
	
	public Integer getRecentWorshipId(){
		Criteria crit = getSession().createCriteria(Worship.class);
		crit.setProjection(Projections.max("id"));
		Integer id = (Integer)crit.uniqueResult();
		return id;
	}
	
	public Worship getRecentWorship() {
		Integer id = getRecentWorshipId();
		return getWorship(id);
	}

	public List<String> getCategorys() {
		Criteria crit = getSession().createCriteria(Worship.class);
		crit.setProjection(Projections.distinct(Projections.property("category")));
		return crit.list();
	}
}
