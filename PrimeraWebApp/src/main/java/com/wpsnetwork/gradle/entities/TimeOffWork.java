package com.wpsnetwork.gradle.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class TimeOffWork {
	@Id
	@GeneratedValue
	private Long id;

	@Column( nullable=false, updatable=false )
	private Date startDate;
	private Date endDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true) // otherwise first ref as POJO, others as id
	private Employee employee;
}
