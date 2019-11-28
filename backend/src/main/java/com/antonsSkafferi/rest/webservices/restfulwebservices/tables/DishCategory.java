/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="dishCategory")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DishCategory {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid", updatable = false, nullable = false)
    private int categoryid;
    @Column(name = "name", updatable = true, nullable = false)
    private String name;
    @Column(name = "url", updatable = true, nullable = false)
    private String url;

    
    public DishCategory(){}
    
    
    public DishCategory(int id, String name, String url) {
        this.categoryid = id;
        this.name = name;
        this.url = url;
    }
    
    
        /**
     * @return the categoryid
     */
    public int getCategoryid() {
        return categoryid;
    }

    /**
     * @param categoryid the categoryid to set
     */
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    @Override
    public String toString(){
        return "DishCategory [id=" + getCategoryid() + ", name=" + getName() + ", url="+ getUrl() + "]";
    }
}
