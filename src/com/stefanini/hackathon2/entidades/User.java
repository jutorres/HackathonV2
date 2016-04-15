package com.stefanini.hackathon2.entidades;

import java.io.Serializable;

import javax.persistence.*;
 
@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findUserByEmail", query = "select u from User u where u.email = :email")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
 
    public static final String FIND_BY_EMAIL = "User.findUserByEmail";
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Role role;
 
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getFindByEmail() {
		return FIND_BY_EMAIL;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isAdmin() {
        return Role.ADMIN.equals(role);
    }
 
    public boolean isUser() {
        return Role.USER.equals(role);
    }
 
    @Override
    public int hashCode() {
        return getId();
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            return user.getId() == id;
        }
 
        return false;
    }
}
