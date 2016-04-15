package com.stefanini.hackathon2.managed.beans;

import java.io.Serializable;
import java.util.*;
 
import javax.faces.bean.*;

import com.stefanini.hackathon2.entidades.Dog;
import com.stefanini.hackathon2.entidades.Person;
import com.stefanini.hackathon2.servicos.DogServico;
import com.stefanini.hackathon2.servicos.PersonServico;
 
 
@ViewScoped
@ManagedBean
public class PersonManagedBean extends AbstractManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private static final String SELECTED_PERSON = "selectedPerson";
 
    private Dog dog;
    private Person person;
    private Person personWithDogs;
    private Person personWithDogsForDetail;
 
    private List<Dog> allDogs;
    private List<Person> persons;
 
    private DogServico dogServico;
    private PersonServico personServico;
 
    public void createPerson() {
        try {
        	getPersonServico().createPerson(person);
            closeDialog();
//            displayInfoMessageToUser("Created With Sucess");
            loadPersons();
            resetPerson();
        } catch (Exception e) {
            keepDialogOpen();
//            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
    public void updatePerson() {
        try {
            getPersonServico().updatePerson(person);
            closeDialog();
//            displayInfoMessageToUser("Updated With Sucess");
            loadPersons();
            resetPerson();
        } catch (Exception e) {
            keepDialogOpen();
//            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
    public void deletePerson() {
        try {
            getPersonServico().deletePerson(person);
            closeDialog();
//            displayInfoMessageToUser("Deleted With Sucess");
            loadPersons();
            resetPerson();
        } catch (Exception e) {
            keepDialogOpen();
//            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
    public void addDogToPerson() {
        try {
            getPersonServico().addDogToPerson(dog.getId(), personWithDogs.getId());
            closeDialog();
//            displayInfoMessageToUser("Added With Sucess");
            reloadPersonWithDogs();
            resetDog();
        } catch (Exception e) {
            keepDialogOpen();
//            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
    public void removeDogFromPerson() {
        try {
            getPersonServico().removeDogFromPerson(dog.getId(), personWithDogs.getId());
            closeDialog();
//            displayInfoMessageToUser("Removed With Sucess");
            reloadPersonWithDogs();
            resetDog();
        } catch (Exception e) {
            keepDialogOpen();
//            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
//    public Person getPersonWithDogs() {
//        if (personWithDogs == null) {
//            if (person == null) {
//                person = (Person) ELFlash.getFlash().get(SELECTED_PERSON);
//            }
// 
//            personWithDogs = getPersonServico().findPersonWithAllDogs(person.getId());
//        }
// 
//        return personWithDogs;
//    }
 
    public void setPersonWithDogsForDetail(Person person) {
        personWithDogsForDetail = getPersonServico().findPersonWithAllDogs(person.getId());
    }
 
    public Person getPersonWithDogsForDetail() {
        if (personWithDogsForDetail == null) {
            personWithDogsForDetail = new Person();
            personWithDogsForDetail.setDogs(new ArrayList<Dog>());
        }
 
        return personWithDogsForDetail;
    }
 
    public void resetPersonWithDogsForDetail(){
        personWithDogsForDetail = new Person();
    }
 
//    public String editPersonDogs() {
//        ELFlash.getFlash().put(SELECTED_PERSON, person);
//        return "/pages/protected/defaultUser/personDogs/personDogs.xhtml";
//    }
 
    public List<Dog> complete(String name) {
        List<Dog> queryResult = new ArrayList<Dog>();
 
        if (allDogs == null) {
            dogServico = new DogServico();
            allDogs = dogServico.listAll();
        }
 
        allDogs.removeAll(personWithDogs.getDogs());
 
        for (Dog dog : allDogs) {
            if (dog.getName().toLowerCase().contains(name.toLowerCase())) {
                queryResult.add(dog);
            }
        }
 
        return queryResult;
    }
 
    public PersonServico getPersonServico() {
        if (personServico == null) {
            personServico = new PersonServico();
        }
 
        return personServico;
    }
 
    public Person getPerson() {
        if (person == null) {
            person = new Person();
        }
 
        return person;
    }
 
    public void setPerson(Person person) {
        this.person = person;
    }
 
    public List<Person> getAllPersons() {
        if (persons == null) {
            loadPersons();
        }
 
        return persons;
    }
 
    private void loadPersons() {
        persons = getPersonServico().listAll();
    }
 
    public void resetPerson() {
        person = new Person();
    }
 
    public Dog getDog() {
        if (dog == null) {
            dog = new Dog();
        }
 
        return dog;
    }
 
    public void setDog(Dog dog) {
        this.dog = dog;
    }
 
    public void resetDog() {
        dog = new Dog();
    }
 
    private void reloadPersonWithDogs() {
        personWithDogs = getPersonServico().findPersonWithAllDogs(person.getId());
    }
}
