package com.wpsnetwork.pcarrier.entidades;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Autor implements java.io.Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String nombre;

	@ManyToMany( fetch=FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idAutor" ), inverseJoinColumns=@JoinColumn( name="idLibro"))
	@JsonIgnore
	private Set<Libro> libros = new HashSet<Libro>(0);

	public Autor(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Libro> getLibros() {
		return libros;
	}
}
