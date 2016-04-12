package com.stefanini.hackathon2.entidades;

import java.time.LocalDateTime;

import javax.faces.convert.FacesConverter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
@FacesConverter("dateConverter")
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, java.sql.Timestamp> {

  @Override
  	public java.sql.Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
	    if (entityValue != null) {
	      return java.sql.Timestamp.valueOf(entityValue);
	    }
	    return null;
	}

  @Override
  	public LocalDateTime convertToEntityAttribute(java.sql.Timestamp databaseValue) {
	    if (databaseValue != null) {
	      return databaseValue.toLocalDateTime();
	    }
	    return null;
	}
}

	

