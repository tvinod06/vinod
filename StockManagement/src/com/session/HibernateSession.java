package com.session;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Transactional
public class HibernateSession {
	@Autowired
	public static SessionFactory sessionFactory;
	private static final Logger LOGGER = Logger.getLogger(HibernateSession.class);
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	@Pointcut("execution(* com.controller.*.*(..))") 
	public void beforeStart(){}
	
	@AfterReturning("beforeStart()")
	public void afterReturningAdvice(){
		Session session = sessionFactory.getCurrentSession();
		if(session.getTransaction().isActive()){
			session.getTransaction().commit();
			LOGGER.error("Transaction commit aspect & session closed");
		}
		session.close();
	}
	
	@AfterThrowing("execution(* com.*.*.*(..))")
	public void AfterThrowingAdvice(){
		Session session = sessionFactory.getCurrentSession();
		if(session.getTransaction().isActive()){
			session.getTransaction().rollback();
			LOGGER.error("Session rolledback aspect");
		}
		session.close();
	}
	
	public Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
			LOGGER.error("getSession & Transaction Begin");
		}
		return session;
	}
}
