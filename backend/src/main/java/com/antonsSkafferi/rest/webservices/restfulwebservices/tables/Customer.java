
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Customer implements Serializable {


    
    @Id
    //WE NEED TO FIX AUTO SHIT. DONT WORK WHEN POST CUSTOMER AT TALBE.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid", updatable = false, nullable = false)
    private int customerid;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Europe/Berlin")
    private Timestamp bookingdatetime;
    
    private String name;
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="dinnertableid")
    private Dinnertable dinnertable;
    
    
    public Customer(){};
    
    public Customer(int customerid, String name, String email, Timestamp bookingdatetime){
    
        this.customerid = customerid;
        this.name = name;
        this.email = email;
        this.bookingdatetime = bookingdatetime;
    }
    
    /**
     * @return the id
     */
    public int getCustomerid() {
        return customerid;
    }

    /**
     * @param id the id to set
     */
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
    
    /**
     * @return the bookingdatetime
     */
    public Timestamp getBookingdatetime() {
        return bookingdatetime;
    }

    /**
     * @param bookingdatetime the bookingdatetime to set
     */
    public void setBookingdatetime(Timestamp bookingdatetime) {
        this.bookingdatetime = bookingdatetime;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
    
    
    @Override
    public String toString(){
        return "Customer [customerid=" + getCustomerid() + ", name=" + getName() + ", bookingDateTime=" + getBookingdatetime()+", email=" + getEmail() + ", dinnertable = " + getDinnertable().getDinnertableid() + "]";
    }
    
}
