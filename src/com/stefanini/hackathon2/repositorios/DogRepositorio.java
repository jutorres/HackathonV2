package com.stefanini.hackathon2.repositorios;

import com.stefanini.hackathon2.entidades.Dog;

public class DogRepositorio extends GenericoRepositorio<Dog> {
 
    private static final long serialVersionUID = 1L;
 
    public DogRepositorio() {
            super(Dog.class);
        }
 
        public void delete(Dog dog) {
            super.delete(dog.getId(), Dog.class);
        }
}
