package com.stefanini.hackathon2.managed.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SearchView {
     
    private String text1;   
 
    public String getText1() {
        return text1;
    }
 
    public void setText1(String text1) {
        this.text1 = text1;
    }
}