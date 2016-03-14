package com.wpsnetwork.pcarrier.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpsnetwork.pcarrier.consola.Indexed;
import com.wpsnetwork.pcarrier.consola.RelationSerializer;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonFilter("CustomSerializer")
public class Libro implements java.io.Serializable, Indexed {

	@Id
	private long id;
	private long edicion;
	private String editorial;
	private long paginas;
	private String titulo;

	@ManyToMany( fetch=FetchType.EAGER )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idAutor"))
	@JsonSerialize(using = RelationSerializer.class)
	private Set<Autor> autors = new HashSet<Autor>(0);

	@ManyToMany( fetch=FetchType.LAZY )
	@JoinTable( name="categoria_libro", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idCategoria"))
	@JsonSerialize(using = RelationSerializer.class)
	private Set<Categoria> categorias = new HashSet<Categoria>(0);

	@OneToMany( mappedBy="libro" )
	@JsonSerialize(using = RelationSerializer.class)
	private Set<Prestamo> prestamos = new HashSet<Prestamo>(0);

	private Libro(){}
	public Libro(long edicion, String editorial, long paginas, String titulo) {
		this.edicion = edicion;
		this.editorial = editorial;
		this.paginas = paginas;
		this.titulo = titulo;
	}
}
