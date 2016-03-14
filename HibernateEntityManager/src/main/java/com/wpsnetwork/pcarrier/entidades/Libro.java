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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Libro implements java.io.Serializable, TableEntity {

	@Id
	@GeneratedValue
	private Long id;
	private long edicion;
	private String editorial;
	private long paginas;
	@Column(unique=true)
	private String titulo;

	@ManyToMany( fetch=FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idAutor"))
	@JsonIgnore
	private Set<Autor> autores = new HashSet<Autor>(0);

	@ManyToMany( fetch=FetchType.LAZY )
	@JoinTable( name="categoria_libro", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idCategoria"))
	private Set<Categoria> categorias = new HashSet<Categoria>(0);

	@OneToMany( mappedBy="libro" )
	private Set<Prestamo> prestamos = new HashSet<Prestamo>(0);

	public Libro(long edicion, String editorial, long paginas, String titulo) {
		this.edicion = edicion;
		this.editorial = editorial;
		this.paginas = paginas;
		this.titulo = titulo;
	}

	public Collection<Autor> getAutores() {
		return autores;
	}
}