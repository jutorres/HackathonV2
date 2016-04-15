package com.stefanini.hackathon2.managed.beans;

import java.io.Serializable;
import java.util.List;
 
import javax.faces.bean.*;

import com.stefanini.hackathon2.entidades.Dog;
import com.stefanini.hackathon2.servicos.DogServico;
 

 
@ViewScoped
@ManagedBean
public class DogManagedBean extends AbstractManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private Dog dog;
    private List<Dog> dogs;
    private DogServico dogServico;
 
    public DogServico getDogServico() {
        if (dogServico == null) {
            dogServico = new DogServico();
        }
 
        return dogServico;
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
 
    public void createDog() {
        try {
            getDogServico().createDog(dog);
            closeDialog();
            displayInfoMessageToUser("Created With Sucess");
            loadDogs();
            resetDog();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
    public void updateDog() {
        try {
            getDogServico().updateDog(dog);
            closeDialog();
            displayInfoMessageToUser("Updated With Sucess");
            loadDogs();
            resetDog();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
    public void deleteDog() {
        try {
            getDogServico().deleteDog(dog);
            closeDialog();
            displayInfoMessageToUser("Deleted With Sucess");
            loadDogs();
            resetDog();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }
 
    public List<Dog> getAllDogs() {
        if (dogs == null) {
            loadDogs();
        }
 
        return dogs;
    }
 
    private void loadDogs() {
        dogs = getDogServico().listAll();
    }
 
    public void resetDog() {
        dog = new Dog();
    }
}
