/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fredriksellgren
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemOrder implements Serializable  {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", updatable = false, nullable = false)
    private Integer orderid;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="dinnertableid", referencedColumnName="dinnertableid", nullable = false)
    private Dinnertable dinnertable;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "itemid", referencedColumnName="itemid" ,nullable = false)
    private Item item;
    
    @Column(name = "amount", updatable = true, nullable = false)
    private int amount;
    
    @Column(name = "note", updatable = true, nullable = true)
    private String note;
    
    public ItemOrder(){}
    
    public ItemOrder(Dinnertable dinnertable, Item item, int amount, String note)
    {
       this.dinnertable = dinnertable;
       this.item = item;
       this.amount = amount;
       this.note = note;
       
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemOrder)) return false;
        ItemOrder that = (ItemOrder) o;
        return Objects.equals(dinnertable.getDinnertableid(), that.dinnertable.getDinnertableid()) &&
                Objects.equals(item.getItemid(), that.item.getItemid()) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(note, that.note);
    }
    
    @Override
    public int hashCode(){
        
    return Objects.hash(dinnertable.getDinnertableid(), item.getItemid(), amount , note);
    }
   
    /**
     * @return the id
     */
    public int getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the id to set
     */
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    /**
     * @return the dinnertable
     */
    public Dinnertable getDinnertable() {
        return dinnertable;
    }

    /**
     * @param dinnertable the dinnertable to set
     */
    public void setDinnertable(Dinnertable dinnertable) {
        this.dinnertable = dinnertable;
    }

    /**
     * @return the dish
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the dish to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the dishAmount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the dishAmount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getNote()
    {
        return note;
    }
    
    public void setNote(String note)
    {
        this.note = note;
    }
    
    @Override
    public String toString(){
        return "Order [orderid=" + getOrderid() + ", dinnertable=" + dinnertable + ", item="+ item + ", amount=" + getAmount() + ", note="+ getNote()+"]";
    }
    
}
