package org.jesus.meslap.user.dao;

import org.jesus.meslap.entity.User;

public interface UserDAO {

	public void save(User user);

	public User get(String userId);

}
