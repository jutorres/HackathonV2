package com.stefanini.hackathon2.servicos;

import java.io.Serializable;
import java.util.List;

import com.stefanini.hackathon2.entidades.Dog;
import com.stefanini.hackathon2.entidades.Person;
import com.stefanini.hackathon2.repositorios.DogRepositorio;
import com.stefanini.hackathon2.repositorios.PersonRepositorio;
 

 
public class PersonServico implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private PersonRepositorio personRespositorio = new PersonRepositorio();
    private DogRepositorio dogRepositorio = new DogRepositorio();
 
    public void createPerson(Person person) {
        personRespositorio.beginTransaction();
        personRespositorio.save(person);
        personRespositorio.commitAndCloseTransaction();
    }
 
    public void updatePerson(Person person) {
        personRespositorio.beginTransaction();
        Person persistedPerson = personRespositorio.find(person.getId());
        persistedPerson.setName(person.getName());
        persistedPerson.setAge(person.getAge());
        personRespositorio.commitAndCloseTransaction();
    }
 
    public void deletePerson(Person person){
        personRespositorio.beginTransaction();
        Person persistedPersonWithIdOnly = personRespositorio.findReferenceOnly(person.getId());
        personRespositorio.delete(persistedPersonWithIdOnly);
        personRespositorio.commitAndCloseTransaction();
 
    }
 
    public Person findPerson(int personId) {
        personRespositorio.beginTransaction();
        Person person = personRespositorio.find(personId);
        personRespositorio.closeTransaction();
        return person;
    }
 
    public List<Person> listAll() {
        personRespositorio.beginTransaction();
        List<Person> result = personRespositorio.findAll();
        personRespositorio.closeTransaction();
 
        return result;
    }
 
    public Person findPersonWithAllDogs(int personId) {
        personRespositorio.beginTransaction();
        Person person = personRespositorio.findPersonWithAllDogs(personId);
        personRespositorio.closeTransaction();
        return person;
    }
 
    public void addDogToPerson(int dogId, int personId) {
        personRespositorio.beginTransaction();
        dogRepositorio.joinTransaction();
        Dog dog = dogRepositorio.find(dogId);
        Person person = personRespositorio.find(personId);
        person.getDogs().add(dog);
        dog.getPersons().add(person);
        personRespositorio.commitAndCloseTransaction();
    }
 
    public void removeDogFromPerson(int dogId, int personId) {
        personRespositorio.beginTransaction();
        dogRepositorio.joinTransaction();
        Dog dog = dogRepositorio.find(dogId);
        Person person = personRespositorio.find(personId);
        person.getDogs().remove(dog);
        dog.getPersons().remove(person);
        personRespositorio.commitAndCloseTransaction();
    }
}
