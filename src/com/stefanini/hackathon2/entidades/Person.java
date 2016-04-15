package com.stefanini.hackathon2.entidades;

import java.io.Serializable;
import java.util.List;
 
import javax.persistence.*;
 
@Entity
@NamedQuery(name = "Person.findUserByIdWithDogs", query = "select p from Person p left join fetch p.dogs where p.id = :personId")
public class Person implements Serializable {
 
    private static final long serialVersionUID = 1L;
    public static final String FIND_USER_BY_ID_WITH_DOGS = "Person.findUserByIdWithDogs";
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int age;
    private String name;
 
    @ManyToMany
    private List<Dog> dogs;
 
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getFindUserByIdWithDogs() {
		return FIND_USER_BY_ID_WITH_DOGS;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	@Override
    public int hashCode() {
        return id;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.getId() == id;
        }
 
        return false;
    }
}
