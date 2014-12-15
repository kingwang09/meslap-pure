package org.jesus.meslap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CMM_USER")
public class User {
	public static String USER_ATTR = "USER";
	@Id
	@Getter @Setter
	private String userId;
	
	@Getter @Setter
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User["+userId+"]";
	}
}
