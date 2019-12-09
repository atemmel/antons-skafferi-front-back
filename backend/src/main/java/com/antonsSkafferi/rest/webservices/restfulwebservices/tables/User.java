/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fredriksellgren
 */
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "userid", updatable = false, nullable = false)
    //private int userid;
    
    @Column(name = "username", updatable = true, nullable = false)
    private String username;
    
    @Column(name = "password", updatable = true, nullable = false)
    private String password;
    
    @Column(name = "administrator", updatable = true, nullable = false)
    private boolean administrator;
    
    
    public User(){}
    
    public User(String username, String password, boolean administrator)
    {
        this.username = username;
        this.password = password;
        this.administrator = administrator;
    
    }
   
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
     * @return the admin
     */
    public boolean isAdministrator() {
        return administrator;
    }

    /**
     * @param administrator the admin to set
     */
    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
    
    
    @Override
    public String toString(){
        return "Users [username=" + getUsername() + ", password=" + getPassword() + ", admin =" + isAdministrator()+"]";
    }
    
}
