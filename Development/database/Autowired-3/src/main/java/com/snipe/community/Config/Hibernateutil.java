package com.snipe.community.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public abstract class Hibernateutil {
	
	
	
	
	@Autowired
	private EntityManagerFactory entityManager;
	
	
	
	@Bean
	@Qualifier(value="sessionFactory")
	public SessionFactory gerSessionFactory()
	{
		
		if(entityManager.unwrap(SessionFactory.class)==null)
		{
			throw new NullPointerException("Factoy is not found");
		}
		
		return entityManager.unwrap(SessionFactory.class);
		
		
	}
	

	/*@Autowired
	@Qualifier(value="sessionFactory")
	               SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session currentSession() {
        return  sessionFactory.getCurrentSession() ;
    }*/

}
