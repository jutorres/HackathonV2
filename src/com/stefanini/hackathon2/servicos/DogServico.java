package com.stefanini.hackathon2.servicos;

import java.io.Serializable;
import java.util.List;

import com.stefanini.hackathon2.entidades.Dog;
import com.stefanini.hackathon2.repositorios.DogRepositorio;
 

 
public class DogServico implements Serializable{
    private static final long serialVersionUID = 1L;
 
    private DogRepositorio dogRepositorio = new DogRepositorio();
 
    public void createDog(Dog dog) {
        dogRepositorio.beginTransaction();
        dogRepositorio.save(dog);
        dogRepositorio.commitAndCloseTransaction();
    }
 
    public void updateDog(Dog dog) {
        dogRepositorio.beginTransaction();
        Dog persistedDog = dogRepositorio.find(dog.getId());
        persistedDog.setAge(dog.getAge());
        persistedDog.setName(dog.getName());
        dogRepositorio.update(persistedDog);
        dogRepositorio.commitAndCloseTransaction();
    }
 
    public Dog findDog(int dogId) {
        dogRepositorio.beginTransaction();
        Dog dog = dogRepositorio.find(dogId);
        dogRepositorio.closeTransaction();
        return dog;
    }
 
    public List<Dog> listAll() {
        dogRepositorio.beginTransaction();
        List<Dog> result = dogRepositorio.findAll();
        dogRepositorio.closeTransaction();
        return result;
    }
 
    public void deleteDog(Dog dog) {
        dogRepositorio.beginTransaction();
        Dog persistedDog = dogRepositorio.findReferenceOnly(dog.getId());
        dogRepositorio.delete(persistedDog);
        dogRepositorio.commitAndCloseTransaction();
    }
}
