package org.jesus.meslap.user.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jesus.meslap.entity.User;
import org.jesus.meslap.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		if(session == null)
			session = sessionFactory.openSession();
		return session;
	}
	
	public void save(User user) {
		getSession().saveOrUpdate(user);
	}
	
	public User get(String userId){
		return (User) getSession().get(User.class, userId);
	}
	
}
