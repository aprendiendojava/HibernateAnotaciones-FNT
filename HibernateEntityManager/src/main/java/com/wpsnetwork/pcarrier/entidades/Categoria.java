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

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Categoria implements java.io.Serializable {

	@Id
	private long id;
	private String nombre;

	@ManyToMany( fetch=FetchType.LAZY )
	@JoinTable( name="categoria_libro", joinColumns=@JoinColumn( name="idCategoria" ), inverseJoinColumns=@JoinColumn( name="idLibro" ))
	private Set<Libro> libros = new HashSet<Libro>(0);

	public Categoria(String nombre) {
		this.nombre = nombre;
	}
}
