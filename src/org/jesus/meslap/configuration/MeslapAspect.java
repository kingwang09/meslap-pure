package org.jesus.meslap.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jesus.meslap.annotation.AdminAuth;
import org.jesus.meslap.entity.User;
import org.jesus.meslap.exception.NeedLoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class MeslapAspect {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private HttpServletRequest request;
	
	@Around("execution(public * *..*Controller.*(..))")
	public Object controllerAuthManager(ProceedingJoinPoint pjp) throws Throwable{
		Class clazz = pjp.getTarget().getClass();
		
		String className = clazz.getSimpleName();
		String methodName = pjp.getSignature().getName();
		
		
		MethodSignature sig = (MethodSignature) pjp.getSignature();
		AdminAuth adminAuth = sig.getMethod().getAnnotation(AdminAuth.class);
		log.debug("------------------------------------------------------------");
		log.debug("execute Controller AuthManage.");
		log.debug("------------------------------------------------------------");
		log.debug("	className = "+className);
		log.debug("	methodName = "+methodName);
		log.debug("	adminAuth = "+(adminAuth!=null));
		
		if(adminAuth!=null){
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(User.USER_ATTR);
			if(user == null){
				String contextPath = request.getContextPath();
				String nowUri = request.getRequestURI();
				if(nowUri.lastIndexOf(contextPath)!=-1){
					nowUri = nowUri.substring(contextPath.length(),nowUri.length());
				}
				String queryString = request.getQueryString();
				if ("".equals(queryString) == false && queryString != null) {
					nowUri += "?" + queryString;
				}
				session.setAttribute("nowUri", nowUri);
				throw new NeedLoginException("You need AdminAuth. please login.");
			}
		}
		return pjp.proceed();
	}
}
