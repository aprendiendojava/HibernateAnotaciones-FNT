package com.wpsnetwork.gradle.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column( insertable=false, updatable=false )
	private Long id;

	@Column( updatable=false, nullable=false )
	private String firstName;

	@Column( updatable=false, nullable=false )
	private String lastName;

	@Column( nullable=true )
	private String office;

	@Type( type="yes_no" )
	@Column( nullable=false )
	private Boolean isOffWork;

	@OneToMany( mappedBy="employee", fetch=FetchType.LAZY )
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true) // otherwise first ref as POJO, others as id
	private Set<TimeOffWork> timesOffWork;

	public Set<TimeOffWork> getTimes(){
		return timesOffWork;
	}
}
