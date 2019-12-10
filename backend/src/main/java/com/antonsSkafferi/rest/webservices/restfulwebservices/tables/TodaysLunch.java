/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author willi
 */
@Entity
@Table(name="todayslunch")
public class TodaysLunch implements Serializable {

    @Id
    @Column(name = "mealname", updatable = false, nullable = false)
    private String mealname;
    
    @Column(name = "days", updatable = true, nullable = false)
    private int days;
    
    @Column(name = "type", updatable = true, nullable = false)
    private String type;

    public TodaysLunch() {
    }
    
    
    
    public TodaysLunch(String mealname, int day, String type)
    {
        this.mealname = mealname;
        this.days = day;
        this.type = type;
    }
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
     * @return the days
     */
    public int getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(int days) {
        this.days = days;
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
        return "TodaysLunch [mealname=" + getMealname() + ", day=" + getDays() + ", type=" + getType() + "]";
    }
}
