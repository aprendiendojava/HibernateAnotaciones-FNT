package com.wpsnetwork.gradle.settings;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.wpsnetwork.gradle.presentation.EmployeeRest;
import com.wpsnetwork.gradle.presentation.TimeOffWorkRest;

@Configuration
public class JerseyRegistrar extends ResourceConfig {
	public JerseyRegistrar() {
		register(JacksonSettings.class);
		register(EmployeeRest.class);
		register(TimeOffWorkRest.class);
	}
}
