package com.wpsnetwork.gradle.presentation;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.wpsnetwork.gradle.entities.TimeOffWork;
import com.wpsnetwork.gradle.persistence.TimeOffWorkRepository;

@Component
@Path("/timeoffwork")
public class TimeOffWorkRest extends GenericRest<TimeOffWork> {
	@Autowired
	TimeOffWorkRepository repo;

	@Override
	protected PagingAndSortingRepository<TimeOffWork, Long> getRepo() {
		return repo;
	}

}
