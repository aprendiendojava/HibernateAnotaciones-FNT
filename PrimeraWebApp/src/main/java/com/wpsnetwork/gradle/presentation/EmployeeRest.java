package com.wpsnetwork.gradle.presentation;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.wpsnetwork.gradle.entities.Employee;
import com.wpsnetwork.gradle.persistence.EmployeeRepository;

@Component
@Path("/employee")
public class EmployeeRest extends GenericRest<Employee> {
	@Autowired
	EmployeeRepository repo;
	
	@Override
	protected PagingAndSortingRepository<Employee, Long> getRepo() {
		return repo;
	}
	
}
