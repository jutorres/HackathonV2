package com.stefanini.hackathon2.entidades;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.faces.convert.FacesConverter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
@FacesConverter("dateConverter")
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

  @Override
  	public Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
	    if (entityValue != null) {
	      return Timestamp.valueOf(entityValue);
	    }
	    return null;
	}

  @Override
  	public LocalDateTime convertToEntityAttribute(Timestamp databaseValue) {
	    if (databaseValue != null) {
	      return databaseValue.toLocalDateTime();
	    }
	    return null;
	}
}

	

