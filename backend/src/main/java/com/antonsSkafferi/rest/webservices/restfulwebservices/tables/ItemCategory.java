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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemcategoryid", updatable = false, nullable = false)
    private int itemcategoryid;
    @Column(name = "name", updatable = true, nullable = false)
    private String name;
    @Column(name = "url", updatable = true, nullable = false)
    private String url;

    
    public ItemCategory(){}
    
    public ItemCategory(int itemcategoryid){
        this.itemcategoryid = itemcategoryid;
    }
    
    public ItemCategory(int itemcategoryid, String name, String url) {
        this.itemcategoryid = itemcategoryid;
        this.name = name;
        this.url = url;
    }
    
    
        /**
     * @return the categoryid
     */
    public int getItemcategoryid() {
        return itemcategoryid;
    }

    /**
     * @param itemcategoryid the categoryid to set
     */
    public void setItemcategoryid(int itemcategoryid) {
        this.itemcategoryid = itemcategoryid;
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
        return "DishCategory [itemcategoryid=" + getItemcategoryid() + ", name=" + getName() + ", url="+ getUrl() + "]";
    }
}
