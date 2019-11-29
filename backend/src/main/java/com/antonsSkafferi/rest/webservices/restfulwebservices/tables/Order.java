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
@Table(name="order_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Serializable  {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", updatable = false, nullable = false)
    private int orderid;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="tableid", nullable = false)
    private Dinnertable dinnertable;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "item",nullable = false)
    private Item item;
    
    @Column(name = "amount", updatable = true, nullable = false)
    private int amount;
    
    public Order(){}
    
    public Order(Item item, int amount)
    {
       this.dinnertable = dinnertable;
       this.item = item;
       this.amount = amount;
       
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order that = (Order) o;
        return Objects.equals(dinnertable.getDinnertableid(), that.dinnertable.getDinnertableid()) &&
                Objects.equals(item.getItemid(), that.item.getItemid()) &&
                Objects.equals(amount, that.amount);
    }
    
    @Override
    public int hashCode(){
        
    return Objects.hash(dinnertable.getDinnertableid(), item.getItemid(), amount);
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
    
    @Override
    public String toString(){
        return "Order [orderid=" + getOrderid() + ", dinnertableid=" + dinnertable + ", itemid="+ item + ", amount=" + getAmount() + "]";
    }
    
}
