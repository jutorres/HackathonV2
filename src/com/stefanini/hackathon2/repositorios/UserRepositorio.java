package com.stefanini.hackathon2.repositorios;

import java.util.*;

import com.stefanini.hackathon2.entidades.User;

 
public class UserRepositorio extends GenericoRepositorio<User> {
 
    private static final long serialVersionUID = 1L;
 
    public UserRepositorio() {
        super(User.class);
    }
 
    public User findUserByEmail(String email){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);     
 
        return super.findOneResult(User.FIND_BY_EMAIL, parameters);
    }
}
