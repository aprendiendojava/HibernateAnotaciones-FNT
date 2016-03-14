package com.wpsnetwork.pcarrier.repositorios;

public abstract class Repo<ENTIDAD extends Object> implements Dao<ENTIDAD> {
	private final Class<ENTIDAD> ent;

	protected Repo(){ ent = null; }
	public Repo( Class<ENTIDAD> entidad ) {
		ent = entidad;
	}

	protected Class<ENTIDAD> getType() {
		return ent;
	};
}