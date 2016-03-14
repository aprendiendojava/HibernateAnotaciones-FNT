package com.wpsnetwork.pcarrier.entidades;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class CustomSerializer extends JsonSerializer<Object> {
	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		try {
			Field f = WriterBasedJsonGenerator.class.getField("_objectCodec" );
			f.setAccessible(true);
			f.set(gen, new ObjectMapper().setFilterProvider(new SimpleFilterProvider().addFilter("CustomSerializer", new CustomFilter())).setConfig(serializers.getConfig()));//.writer(new SimpleFilterProvider().setDefaultFilter(new CustomFilter())) );
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		gen.writeObject(value);
//		gen.getCodec().
//		gen.writeFieldName("Prueba");
//		gen.writeStartObject();
//		new ObjectMapper().addMixIn(value.getClass(), TableEntity.class).setFilterProvider(new SimpleFilterProvider().setDefaultFilter(new CustomFilter())).setConfig(serializers.getConfig()).writerFor(value.getClass()).writeValueAsString(value);//.writer(new SimpleFilterProvider().setDefaultFilter(new CustomFilter())).writeValue(gen, value);		
//		gen.writeEndObject();
	}

	public static class CustomFilter extends SimpleBeanPropertyFilter {
		@Override
		public void serializeAsField (Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
		throws Exception {
			if (include(writer)) {
	         if ( writer.getAnnotation(ManyToMany.class) == null
	        	&& writer.getAnnotation(ManyToOne.class) == null
	        	&& writer.getAnnotation(OneToMany.class) == null ) {
	            writer.serializeAsField(pojo, jgen, provider);
	            return;
	         }
	         else {
	        	 jgen.writeFieldName(writer.getName());
	        	 Collection c = (Collection) writer.getMember().getValue(pojo);
	        	 jgen.writeStartArray();
	        	 c.forEach(x-> {
	        		 try {
						Field f = x.getClass().getDeclaredField("id");
						f.setAccessible(true);
		        		 jgen.writeNumber((Long) f.get(x));
					} catch (Exception e) {
						e.printStackTrace();
					}
	        	 });
	        	 jgen.writeEndArray();
	         }
	        	 
	      } else if (!jgen.canOmitFields()) { // since 2.3
	         writer.serializeAsOmittedField(pojo, jgen, provider);
	      }
	   }
	}
}
