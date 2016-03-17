package com.wpsnetwork.gradle.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wpsnetwork.gradle.entities.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{}
