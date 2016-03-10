package com.wpsnetwork.pcarrier.entidades;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wpsnetwork.pcarrier.consola.Indexed;
import com.wpsnetwork.pcarrier.consola.RelationSerializer;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Persona implements java.io.Serializable, Indexed {

	@Id
	private long id;
	private long codigopostal;
	private String direccion;
	private String dni;
	@Transient
	private LocalDate fechanacimiento;
	private String nombre;
	private String pais;
	private String provincia;
	private String telefono;

	@OneToMany( mappedBy="persona" )
	@JsonSerialize(using = RelationSerializer.class)
	private Set<Prestamo> prestamos = new HashSet<Prestamo>(0);

	private Persona(){}
	public Persona(long codigopostal, String direccion, String dni, LocalDate fechanacimiento, String nombre,
			String pais, String provincia, String telefono) {
		this.codigopostal = codigopostal;
		this.direccion = direccion;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
		this.nombre = nombre;
		this.pais = pais;
		this.provincia = provincia;
		this.telefono = telefono;
	}
}
