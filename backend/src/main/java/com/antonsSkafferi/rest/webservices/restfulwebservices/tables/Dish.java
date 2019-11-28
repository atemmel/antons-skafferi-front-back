    
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dish")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dish implements Serializable {





    //@Id Specifies the primary key of an entity
    @Id
    @Column(name = "dishid", updatable = false, nullable = false)
    private int dishid;
    
    @Column(name = "title", updatable = false, nullable = false)
    private String title;
    
    @Column(name = "price", updatable = true, nullable = false)
    private int price;
    
    @Column(name = "description", updatable = true, nullable = false)
    private String description;
    
    @Column(name = "type", updatable = true, nullable = false)
    private String type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryid", insertable = false, updatable = false)
    private DishCategory dishCategory;
    
    @Column(name = "categoryid", updatable = true, nullable = false)
    private int categoryid;
    
    //@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    //private Set<Order> order = new HashSet<>();
    
    public Dish(){}
    
    public Dish(int dishid, String title, int price, String description, String type, int categoryid)
    {
        this.dishid = dishid;
        this.title = title;
        this.price = price;
        this.description = description;
        this.type = type;
        this.categoryid = categoryid;
    }
    
    
     /**
     * @return the dishid
     */
    public int getDishid() {
        return dishid;
    }

    /**
     * @param dishid the dishid to set
     */
    public void setDishid(int dishid) {
        this.dishid = dishid;
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
    

    /**
     * @param category the category to set
     */
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
    
     /**
     * @return the categoryid
     */
    public DishCategory getCategoryid() {
        return dishCategory;
    }

    public void setCategoryid(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }
  
    
    @Override
    public String toString(){
        return "Dish [title=" + getTitle() + ", price=" + getPrice() + ", description=" + getDescription() + ",type=" + getType() + ", dishcategory=" + dishCategory +"]";
    }
      
}
