package com.wpsnetwork.pcarrier.repositorios;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public interface Dao<ENTIDAD extends Object> {
	public void insert( ENTIDAD object );
	public ENTIDAD get( Object index );
	public void update( ENTIDAD update );
	public void delete( ENTIDAD object );
	public Collection<ENTIDAD> getAll();

	public static class Factory {
		public static <ENTIDAD extends Object, DAO extends Repo<ENTIDAD>> Dao<ENTIDAD> getInstance( Class<DAO> repo, Class<ENTIDAD> entidad ) {
			try {
				return (Dao<ENTIDAD>) sun.reflect.ReflectionFactory.getReflectionFactory().newConstructorForSerialization( repo, Repo.class.getConstructor(Class.class)).newInstance(entidad);
			} catch ( InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e ) {
				throw new RuntimeException(e.getMessage());
			}
		}	
	}
}