package com.stefanini.hackathon2.managed.beans;

import java.io.Serializable;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.stefanini.hackathon2.entidades.User;
 
 
@SessionScoped
@ManagedBean(name="userMB")
public class UserManagedBean implements Serializable {
    public static final String INJECTION_NAME = "#{userMB}";
    private static final long serialVersionUID = 1L;
 
    private User user;
 
    public boolean isAdmin() {
        return user.isAdmin();
    }
 
    public boolean isDefaultUser() {
        return user.isUser();
    }
 
    public String logOut() {
        getRequest().getSession().invalidate();
        return "/pages/public/login.xhtml";
    }
 
    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
}
