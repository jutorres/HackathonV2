package com.stefanini.hackathon2.managed.beans;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.stefanini.hackathon2.entidades.User;
import com.stefanini.hackathon2.servicos.UserServico;
 
 
@RequestScoped
@ManagedBean
public class LoginManagedBean extends AbstractManagedBean {
    @ManagedProperty(value = UserManagedBean.INJECTION_NAME)
    private UserManagedBean userManagedBean;
 
    private String email;
    private String password;
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String login() {
        UserServico userServico = new UserServico();
 
        User user = userServico.isValidLogin(email, password);
 
        if(user != null){
            userManagedBean.setUser(user);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("user", user);
            return "/pages/protected/index.xhtml";
        }
 
        displayErrorMessageToUser("Check your email/password");
 
        return null;
    }
 
    public void setUserManagedBean(UserManagedBean userManagedBean) {
        this.userManagedBean = userManagedBean;
    }   
}
