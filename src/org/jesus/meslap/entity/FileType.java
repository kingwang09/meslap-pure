package org.jesus.meslap.entity;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.UserType;
import org.springframework.web.multipart.MultipartFile;

public class FileType implements CompositeUserType {

	public String[] getPropertyNames() {
		return new String[]{"filePath","fileName"};
	}

	public Type[] getPropertyTypes() {
		return new Type[]{StringType.INSTANCE, StringType.INSTANCE};
	}
	
	public Class returnedClass() {
		return MultipartFile.class;
	}

	public Object getPropertyValue(Object component, int property)
			throws HibernateException {
		MultipartFile file = (MultipartFile)component;
//		switch(property){
//			case 1 :
//				return file.get
//		}
		return null;
	}

	public void setPropertyValue(Object component, int property, Object value)
			throws HibernateException {
		// TODO Auto-generated method stub
		
	}



	public boolean equals(Object x, Object y) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode(Object x) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		//StringType.INSTANCE.get()
		return null;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	public Serializable disassemble(Object value, SessionImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object assemble(Serializable cached, SessionImplementor session,
			Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object replace(Object original, Object target,
			SessionImplementor session, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
