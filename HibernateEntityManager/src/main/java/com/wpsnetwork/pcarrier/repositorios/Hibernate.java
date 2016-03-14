package com.wpsnetwork.pcarrier.repositorios;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Hibernate<ENTIDAD extends Object> extends Repo<ENTIDAD> {
	private static EntityManager theManager =
		Persistence.createEntityManagerFactory("thePersistenceUnit").createEntityManager();

	@Override
	public void insert(Object object) {
        theManager.getTransaction().begin();
        theManager.persist(object);
        theManager.getTransaction().commit();
	}

	@Override
	public ENTIDAD get(Object index) {
		theManager.getTransaction().begin();
		Object o = theManager.find(getType(), index );
//		theManager.merge(o);
//		theManager.refresh(o);
		theManager.getTransaction().commit();
		return (ENTIDAD)o;
	}

	@Override
	public void update(ENTIDAD update) {
        theManager.getTransaction().begin();
		theManager.merge(update);
        theManager.getTransaction().commit();
	}

	@Override
	public void delete(ENTIDAD object) {
        theManager.getTransaction().begin();
		theManager.remove(object);
        theManager.getTransaction().commit();
	}

	@Override
	public Collection<ENTIDAD> getAll() {
		theManager.getTransaction().begin();
		Collection<ENTIDAD> c = theManager.createQuery("FROM "+getType().getSimpleName(), getType()).getResultList();
		c.stream().forEach(x->theManager.refresh(x));
		theManager.getTransaction().commit();
		return c;
	}
}
