    
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dish {

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
  
    //@Id Specifies the primary key of an entity
    @Id
    @Column(name = "title", updatable = false, nullable = false)
    private String title;
    
    @Column(name = "price", updatable = true, nullable = false)
    private int price;
    
    @Column(name = "description", updatable = true, nullable = false)
    private String description;
    
    @Column(name = "type", updatable = true, nullable = false)
    private String type;
    
    public Dish(){}
    
    public Dish(String title, int price, String description, String type)
    {
        this.title = title;
        this.price = price;
        this.description = description;
        this.type = type;
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
    
@Override
    public String toString(){
        return "Dish [title=" + getTitle() + ", price=" + getPrice() + ", description=" + getDescription() + ",type=" + getType() + "]";
    }
      
}