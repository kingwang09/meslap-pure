package org.jesus.meslap.configuration;


import javax.annotation.PostConstruct;

import org.jesus.meslap.entity.User;
import org.jesus.meslap.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	public void InitService() {
		log.debug("---------------------------");
		log.debug("Init Service start.");
		log.debug("---------------------------");
		User user = insertAdminData();
		log.debug("---------------------------");
		log.debug("insert Meslap Admin. "+user);
		log.debug("---------------------------");
	}
	
	public User insertAdminData(){
		User user = userService.get("meslap");
		if(user == null){
			user = new User("meslap", "admin");
			userService.save(user);
		}
		return user;
	}
}
