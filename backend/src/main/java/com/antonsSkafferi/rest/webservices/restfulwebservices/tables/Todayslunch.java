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
    @Column(name = "mealname", updatable = false, nullable = false)
    private String mealname;
    
    @Column(name = "day", updatable = true, nullable = false)
    private int day;
    
    @Column(name = "type", updatable = true, nullable = false)
    private String type;
    

    
    
}
