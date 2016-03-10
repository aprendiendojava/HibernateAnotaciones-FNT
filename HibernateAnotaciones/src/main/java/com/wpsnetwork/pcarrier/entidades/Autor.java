package com.wpsnetwork.pcarrier.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpsnetwork.pcarrier.consola.Indexed;
import com.wpsnetwork.pcarrier.consola.RelationSerializer;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Autor implements java.io.Serializable, Indexed {

	@Id
	private long id;
	private String nombre;

	@ManyToMany( fetch=FetchType.LAZY )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idAutor" ), inverseJoinColumns=@JoinColumn( name="idLibro"))
	@JsonSerialize(using = RelationSerializer.class)
	private Set<Libro> libros = new HashSet<Libro>(0);

	private Autor(){}
	public Autor(String nombre) {
		this.nombre = nombre;
	}
}
