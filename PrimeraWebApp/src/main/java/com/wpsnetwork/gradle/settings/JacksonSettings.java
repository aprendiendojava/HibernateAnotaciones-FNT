package com.wpsnetwork.gradle.settings;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Provider
public class JacksonSettings implements ContextResolver<ObjectMapper> {
	private static ObjectMapper om = new ObjectMapper()
			.registerModule(new Hibernate5Module()
					.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING))
			.setVisibility(PropertyAccessor.FIELD,Visibility.ANY)
			.setVisibility(PropertyAccessor.CREATOR,Visibility.NONE)
			.setVisibility(PropertyAccessor.GETTER, Visibility.NONE)
			.setVisibility(PropertyAccessor.IS_GETTER, Visibility.NONE)
			.setVisibility(PropertyAccessor.SETTER, Visibility.NONE)
			.enable(SerializationFeature.INDENT_OUTPUT);

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return om;
	}
}