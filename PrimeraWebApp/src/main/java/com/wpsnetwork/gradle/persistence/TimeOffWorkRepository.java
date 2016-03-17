package com.wpsnetwork.gradle.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wpsnetwork.gradle.entities.TimeOffWork;

public interface TimeOffWorkRepository extends PagingAndSortingRepository<TimeOffWork, Long> {}
