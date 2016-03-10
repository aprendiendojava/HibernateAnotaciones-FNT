package com.wpsnetwork.pcarrier.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wpsnetwork.pcarrier.consola.Indexed;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Prestamo implements java.io.Serializable, Indexed {

	@Id
	private long id;

	@ManyToOne
	@JoinColumn(name="idLibro")
	private Libro libro;

	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	private boolean devuelto;
	@Transient
	private LocalDate fechafin;
	@Transient
	private LocalDate fechainicio;

	private Prestamo(){}
	public Prestamo(Libro libro, Persona persona, boolean devuelto, LocalDate fechafin,
			LocalDate fechainicio) {
		this.libro = libro;
//		this.persona = persona;
		this.devuelto = devuelto;
		this.fechafin = fechafin;
		this.fechainicio = fechainicio;
	}
}
