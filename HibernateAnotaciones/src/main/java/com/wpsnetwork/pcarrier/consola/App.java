package com.wpsnetwork.pcarrier.consola;

import org.hibernate.Session;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.wpsnetwork.pcarrier.entidades.Prestamo;

public class App 
{
	private static final ObjectMapper om = new ObjectMapper();
	static {
		om.registerModule( new Hibernate4Module()
			.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING)
		).setVisibility(
			om.getSerializationConfig()
			.getDefaultVisibilityChecker()
			.withFieldVisibility(Visibility.ANY)
			.withGetterVisibility(Visibility.NONE)
			.withSetterVisibility(Visibility.NONE)
			.withCreatorVisibility(Visibility.NONE)
		);
		System.setProperty("org.jboss.logging.provider", "log4j2");
	}

    public static void main( String[] args ) throws JsonProcessingException {
    	Session s = HibernateUtil.getSession();
    	s.beginTransaction();
    	System.out.println( om.writerWithDefaultPrettyPrinter().writeValueAsString(s.get(Prestamo.class, 1L)));
    	s.getTransaction().commit();
        HibernateUtil.setDown();
    }
}
