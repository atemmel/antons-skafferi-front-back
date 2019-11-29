    
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item implements Serializable {

    //@Id Specifies the primary key of an entity
    @Id
    @Column(name = "itemid", updatable = false, nullable = false)
    private int itemid;
    
    @Column(name = "title", updatable = false, nullable = false)
    private String title;
    
    @Column(name = "price", updatable = true, nullable = false)
    private int price;
    
    @Column(name = "description", updatable = true, nullable = false)
    private String description;
    
    @Column(name = "type", updatable = true, nullable = false)
    private String type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="itemcategoryid", insertable = false, updatable = false)
    @JoinColumn(name = "itemcategoryid", nullable = true)
    private ItemCategory itemcategory;
    
    //@Column(name = "itemcategoryid", updatable = true, nullable = false)
    //private int itemcategoryid;
    
    //@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    //private Set<Order> order = new HashSet<>();
    
    public Item(){}
    
    public Item(int itemid, String title, int price, String description, String type/*,int itemcategoryid*/)
    {
        this.itemid = itemid;
        this.title = title;
        this.price = price;
        this.description = description;
        this.type = type;
        //this.itemcategoryid = itemcategoryid;
    }
    
    
    /**
     * @return the dishid
     */
    public int getItemid() {
        return itemid;
    }

    /**
     * @param itemid the dishid to set
     */
    public void setItemid(int itemid) {
        this.itemid = itemid;
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
     * @param itemcategoryid the category to set
     */
    /*public void setItemcategoryid(int itemcategoryid) {
        this.itemcategoryid = itemcategoryid;
    }*/
    
     /**
     * @return the categoryid
     */
    public ItemCategory getItemcategory() {
        return itemcategory;
    }

    public void setItemcategory(ItemCategory itemcategory) {
        this.itemcategory = itemcategory;
    }
  
    
    @Override
    public String toString(){
        return "Item [Item= " + getItemid() + ", title=" + getTitle() + ", price=" + getPrice() + ", description=" + getDescription() + ",type=" + getType() + ", itemcategory=" + itemcategory +"]";
    }
      
}
