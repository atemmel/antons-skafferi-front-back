/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fredriksellgren
 */
@Entity
@Table(name="todayLunch")
public class TodaysLunch {

    @Id
    @Column(name = "mealname", updatable = false, nullable = false)
    private String mealname;
    
    @Column(name = "day", updatable = true, nullable = false)
    private int day;
    
    @Column(name = "type", updatable = true, nullable = false)
    private String type;
    
        /**
     * @return the mealname
     */
    public String getMealname() {
        return mealname;
    }

    /**
     * @param mealname the mealname to set
     */
    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString(){
        return "TodaysLunch [mealname=" + getMealname() + ", day=" + getDay() + ", type=" + getType() + "]";
    }
}
