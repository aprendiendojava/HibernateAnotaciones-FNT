package com.wpsnetwork.gradle.presentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.data.repository.PagingAndSortingRepository;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class GenericRest<T> {
	protected abstract PagingAndSortingRepository<T, Long> getRepo();

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Long id) {
		return Response.ok(getRepo().findOne(id)).build();
	}

	@GET
	@Path("/all")
	public Response findAll() {
		return Response.ok(getRepo().findAll()).build();
	}

	@POST
	public Response save(T entity) {
		return Response.ok(getRepo().save(entity)).build();
	}
}
