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
    @JoinColumn(name = "dish",nullable = true)
    private Dish dish;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "drink", nullable = true)
    private Drink drink;
    
    @Column(name = "dishamount", updatable = true, nullable = true)
    private int dishAmount;
    @Column(name = "drinkamount", updatable = true, nullable = true)
    private int drinkAmount;
    
    public Order(){}
    
    public Order(Dish dish, Drink drink, int dishAmount, int drinkAmount)
    {
       this.dinnertable = dinnertable;
       this.dish = dish;
       this.drink = drink;
       this.dishAmount = dishAmount;
       this.drinkAmount = drinkAmount;
       
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order that = (Order) o;
        return Objects.equals(dinnertable.getDinnertableid(), that.dinnertable.getDinnertableid()) &&
                Objects.equals(dish.getDishid(), that.dish.getDishid()) &&
                Objects.equals(dishAmount, that.dishAmount) &&
                Objects.equals(drink.getDrinkid(), that.drink.getDrinkid()) &&
                Objects.equals(drinkAmount, that.drinkAmount);
    }
    
    @Override
    public int hashCode(){
        
    return Objects.hash(dinnertable.getDinnertableid(), dish.getDishid(), drink.getDrinkid(), dishAmount, drinkAmount);
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
    public Dish getDish() {
        return dish;
    }

    /**
     * @param dish the dish to set
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     * @return the drink
     */
    public Drink getDrink() {
        return drink;
    }

    /**
     * @param drink the drink to set
     */
    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    /**
     * @return the dishAmount
     */
    public int getDishAmount() {
        return dishAmount;
    }

    /**
     * @param dishAmount the dishAmount to set
     */
    public void setDishAmount(int dishAmount) {
        this.dishAmount = dishAmount;
    }

    /**
     * @return the drinkAmount
     */
    public int getDrinkAmount() {
        return drinkAmount;
    }

    /**
     *@param drinkAmount the drinkAmount to set
    */
    public void setDrinkAmount(int drinkAmount) {
        this.drinkAmount = drinkAmount;
    }
    
    @Override
    public String toString(){
        return "Order [id=" + getOrderid() + ", dishamount=" + getDishAmount() + ", dishid="+ dish + ", drinkamount=" + getDrinkAmount() + ", drinkid=" + drink +"]";
    }
    
}
