package com.wpsnetwork.pcarrier.consola;

import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class RelationSerializer extends JsonSerializer<Collection<Indexed>> 
{
	@Override
	public void serialize(Collection<Indexed> arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		arg1.writeStartArray();
		for (Indexed i : arg0) {
			arg1.writeNumber(i.getId());
		}
		arg1.writeEndArray();
	}

}