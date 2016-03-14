package com.wpsnetwork.pcarrier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.wpsnetwork.pcarrier.entidades.Autor;
import com.wpsnetwork.pcarrier.entidades.CustomSerializer;
import com.wpsnetwork.pcarrier.entidades.Libro;
import com.wpsnetwork.pcarrier.repositorios.Dao;
import com.wpsnetwork.pcarrier.repositorios.Hibernate;

public class App {
	private static final ObjectMapper om = new ObjectMapper();
	static {
//		om.registerModule( new Hibernate4Module()
//			.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING)
//		)
//		om.setFilterProvider(new SimpleFilterProvider().addFilter("CustomSerializer", new CustomSerializer.CustomFilter()));
//		System.setProperty("org.jboss.logging.provider", "log4j2");
	}

    public static void main( String...strings ) throws JsonProcessingException {
    	Dao<Autor> autores = Dao.Factory.getInstance(Hibernate.class, Autor.class);
    	Dao<Libro> libros = Dao.Factory.getInstance(Hibernate.class, Libro.class);
    	autores.insert(new Autor("Charles Dickens"));
        libros.insert(new Libro( 1, "Editorial1", 200, "Great Expectations" ));
        autores.get(1L).getLibros().add(libros.get(2L));
    	autores.get(1L).getLibros().add(new Libro(2, "WAWFA", 100, "DADADAD"));
    	libros.get(2L).getAutores().add(new Autor("Charles Baudelaire"));
    	libros.update(libros.get(2L));
    	//System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString( autores.getAll()));
    	autores.get(4L).getLibros().add(new Libro(1L, "Editorial 1", 300, "Moby Dick" ));
    	autores.delete(autores.get(1L));
    	//autores.get(1L).getLibros().add(new Libro(1L, "Editorial 2", 200, "The Dubliners" ));
    	//autores.insert( autores.get(1L));

    	
    	libros.get(2L).getAutores().add(new Autor("Bill Collins"));
    	libros.update( libros.get(2L));


//    	autores.getAll().forEach(x->AnnotationUtils.getAnnotatedFields(x, Id.class).forEach(y->{
//    		try {
//    			y.setAccessible(true);
//				System.out.println( y.get(x));
//    		} catch( Exception e ) {
//    			e.printStackTrace();
//    		}
//    	}));
    	System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString( libros.getAll()));
    	System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString( autores.getAll()));
//    	autores.update(new Autor(1L, "Carlos Dickens"));
    }
}