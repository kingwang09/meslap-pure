package org.jesus.meslap.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ExceptionHandler 가 잡을 수 있는 건 RuntimeException임.
 * @author eun
 *
 */
public class NeedLoginException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = LoggerFactory.getLogger(getClass());
	public NeedLoginException(String errorMsg){
		log.error(errorMsg);
	}
	
	
}
