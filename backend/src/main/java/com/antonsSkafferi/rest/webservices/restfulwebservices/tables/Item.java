    
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
  
    //@Id Specifies the primary key of an entity
    @Id
    @Column(name = "title", updatable = false, nullable = false)
    private String title;
    @Column(name = "price", updatable = true, nullable = false)
    private int price;
    @Column(name = "description", updatable = true, nullable = false)
    private String description;
    
    public Item(){}
    
    public Item(String title, int price, String description)
    {
        this.title = title;
        this.price = price;
        this.description = description;
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
        return "Meal [title=" + getTitle() + ", price=" + getPrice() + ", description=" + getDescription() + "]";
    }
      
}
