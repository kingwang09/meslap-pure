package org.jesus.meslap.user.service.impl;

import org.jesus.meslap.entity.User;
import org.jesus.meslap.user.dao.UserDAO;
import org.jesus.meslap.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDao;
	
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}
	@Transactional
	public User get(String userId) {
		return userDao.get(userId);
	}

}
