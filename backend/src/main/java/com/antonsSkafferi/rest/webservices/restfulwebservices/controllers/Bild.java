/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

/**
 *
 * @author ninhow
 */
public class Bild {
    private String title;
    private String date;
    private byte[] image;
    private String imageName;
    
    public void setImage(byte[] base64Image){
        this.image = base64Image;
    }
    
    public void setImageName(String imageName){
        this.imageName = imageName;
    }
    
    public String getImageName(){
        return this.imageName;
    }
    
    public byte[]  getImage(){
        return this.image;
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
     * @return the data
     */
    public String getDate() {
        return date;
    }

    /**
     * @param data the data to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}
