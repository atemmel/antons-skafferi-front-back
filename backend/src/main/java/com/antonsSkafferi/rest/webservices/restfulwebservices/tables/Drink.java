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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author willi
 */
@Entity
@Table(name="drink")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Drink implements Serializable {


    @Id
    @Column(name="drinkid", updatable = false, nullable = false)
    private int drinkid;
    
    @Column(name="title", updatable = false, nullable = false)
    private String title;
    
    @Column(name="description", updatable = true, nullable = false)
    private String description;
    
    @Column(name="price", updatable = true, nullable = false)
    private int price;
    
    //@OneToMany(mappedBy = "drink", cascade = CascadeType.ALL)
    //private Set<Order> order = new HashSet<>();
    
    
    public Drink(){}
    
    public Drink(int drinkid, String title, String description, int price) {
        this.drinkid = drinkid;
        this.title = title;
        this.description = description;
        this.price = price;
    }
    
    /**
     * @return the drinkid
     */
    public int getDrinkid() {
        return drinkid;
    }

    /**
     * @param drinkid the drinkid to set
     */
    public void setDrinkid(int drinkid) {
        this.drinkid = drinkid;
    }
    
    
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
     /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "Drink [title=" + getTitle() + ", description=" + getDescription() + ", price=" + getPrice() + "]";
    }
   
}
