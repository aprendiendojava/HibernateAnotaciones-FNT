package com.wpsnetwork.pcarrier.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Prestamo implements java.io.Serializable {

	@Id
	private long id;

	@ManyToOne
	@JoinColumn(name="idLibro")
	private Libro libro;

	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	private boolean devuelto;
	private LocalDate fechafin;
	private LocalDate fechainicio;

	public Prestamo(Libro libro, Persona persona, boolean devuelto, LocalDate fechafin,
			LocalDate fechainicio) {
		this.libro = libro;
		this.devuelto = devuelto;
		this.fechafin = fechafin;
		this.fechainicio = fechainicio;
	}
}