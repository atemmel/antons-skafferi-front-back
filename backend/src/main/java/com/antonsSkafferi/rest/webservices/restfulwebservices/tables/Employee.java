/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fredriksellgren
 */
@Entity
@Table(name= "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid", updatable = false, nullable = false)
    private int employeeid;
    
    @Column(name = "fname", updatable = false, nullable = false)
    private String fname;
    
    @Column(name = "lname", updatable = false, nullable = false)
    private String lname;
    
    //@Column(name ="username", updatable = false, nullable = false)
    //private String username;
    @ManyToOne(fetch = FetchType.LAZY /*,optional = false*/)
    @JoinColumn(name = "username", nullable = true)
    private User user;
    
    
    public Employee(){}
    
    public Employee(String fname, String lname){
        
        this.fname = fname;
        //this.username = username;
        this.lname = lname;
        
    }
    
    
    public Employee(int employeeid, String fname, String lname){
        
        this.employeeid = employeeid;
        this.fname = fname;
        //this.username = username;
        this.lname = lname;
        
    }
    
    
    /**
     * @return the employeeid
     */
    public int getEmployeeid() {
        return employeeid;
    }

    /**
     * @param employeeid the employeeid to set
     */
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }
    
    public User getUser() {
        return user;
    }
   
    @Override
    public String toString(){
        return "Employee [employeeid = " + getEmployeeid() + ", fname=" + getFname() + ",lname =" + getLname() + ", user=" + user + "]";
    }
    
}
