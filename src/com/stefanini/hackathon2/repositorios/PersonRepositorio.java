package com.stefanini.hackathon2.repositorios;

import java.util.*;

import com.stefanini.hackathon2.entidades.Person;
 
public class PersonRepositorio extends GenericoRepositorio<Person> {
 
    private static final long serialVersionUID = 1L;
 
    public PersonRepositorio() {
        super(Person.class);
    }
 
    public Person findPersonWithAllDogs(int personId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("personId", personId);
 
        return super.findOneResult(Person.FIND_USER_BY_ID_WITH_DOGS, parameters);
    }
        public void delete(Person person) {
            super.delete(person.getId(), Person.class);
        }
}
