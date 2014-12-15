package org.jesus.meslap.user.service;

import org.jesus.meslap.entity.User;

public interface UserService {
	public User get(String userId);
	public void save(User user);
}
