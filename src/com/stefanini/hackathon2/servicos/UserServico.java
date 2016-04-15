package com.stefanini.hackathon2.servicos;

import com.stefanini.hackathon2.entidades.User;
import com.stefanini.hackathon2.repositorios.UserRepositorio;

public class UserServico {
    private UserRepositorio userRepositorio = new UserRepositorio();
 
    public User isValidLogin(String email, String password) {
        userRepositorio.beginTransaction();
        User user = userRepositorio.findUserByEmail(email);
 
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
 
        return user;
    }
}
