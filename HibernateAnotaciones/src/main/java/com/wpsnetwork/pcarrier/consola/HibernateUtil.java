package com.wpsnetwork.pcarrier.consola;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private static Session session = sessionFactory.openSession();

	public static Session getSession() {
		return session;
	}

	public static void setDown(){
		sessionFactory.close();
	}
}
