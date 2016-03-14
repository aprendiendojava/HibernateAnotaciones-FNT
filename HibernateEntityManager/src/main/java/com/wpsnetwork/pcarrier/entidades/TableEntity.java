package com.wpsnetwork.pcarrier.entidades;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonSerialize(using=CustomSerializer.class)
@JsonFilter("CustomSerializer")
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE
				, fieldVisibility = JsonAutoDetect.Visibility.ANY
				, isGetterVisibility = JsonAutoDetect.Visibility.NONE
				, creatorVisibility = JsonAutoDetect.Visibility.NONE
				, setterVisibility = JsonAutoDetect.Visibility.NONE ) 
public interface TableEntity {

}
