/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author fredriksellgren
 */
@Entity
public class Todayslunch {

    @Id
    @Column(name = "day", updatable = false, nullable = false)
    private String day;
    
    @Column(name = "dish1", updatable = true, nullable = false)
    private String dish1;
    
    @Column(name = "dish2", updatable = true, nullable = false)
    private String dish2;
        
    @Column(name = "dish3", updatable = true, nullable = false)
    private String dish3;
    
    
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    public String getDish1() {
        return dish1;
    }

    public void setDish1(String dish1) {
        this.dish1 = dish1;
    }
    

    public String getDish2() {
        return dish2;
    }


    public void setDish2(String dish2) {
        this.dish2 = dish2;
    }

    public String getDish3() {
        return dish3;
    }

    public void setDish3(String dish3) {
        this.dish3 = dish3;
    }
    
}
