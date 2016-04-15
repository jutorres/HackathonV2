package com.stefanini.hackathon2.managed.beans;

import org.primefaces.context.RequestContext;

import com.stefanini.hackathon2.util.JSFMessageUtil;

public class AbstractManagedBean {
    private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
 
    public AbstractManagedBean() {
        super();
    }
 
    protected void displayErrorMessageToUser(String message) {
        JSFMessageUtil messageUtil = new JSFMessageUtil();
        messageUtil.sendErrorMessageToUser(message);
    }
 
    protected void displayInfoMessageToUser(String message) {
        JSFMessageUtil messageUtil = new JSFMessageUtil();
        messageUtil.sendInfoMessageToUser(message);
    }
 
    protected void closeDialog(){
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
    }
 
    protected void keepDialogOpen(){
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
    }
 
    protected RequestContext getRequestContext(){
        return RequestContext.getCurrentInstance();
    }
}
