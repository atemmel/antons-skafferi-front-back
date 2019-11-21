
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Items {
  
    //@Id Specifies the primary key of an entity
    @Id private String title;
    private int price;
    private String description;
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
