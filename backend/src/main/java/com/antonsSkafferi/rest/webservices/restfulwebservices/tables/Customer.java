
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name="customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid", updatable = false, nullable = false)
    private int customerid;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Europe/Berlin")
    private Timestamp bookingdatetime;
    @Column(name = "firstname", updatable = true, nullable = false)
    private String firstname;
    @Column(name="lastname", updatable = true, nullable = false)
    private String lastname;
    @Column(name = "email", updatable = true, nullable = false)
    private String email;
    
    @ManyToOne(fetch = FetchType.LAZY /*,optional = false*/)
    @JoinColumn(name = "dinnertableid", nullable = true)
    private Dinnertable dinnertable;
    
    
    public Customer(){};
    
    public Customer(int customerid, String firstname, String lastname, String email, Timestamp bookingdatetime){
    
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
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
     * @param customerid the id to set
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
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the name to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        return "Customer [customerid=" + getCustomerid() + ", firstname=" + getFirstname() + ", lastname=" + getLastname() + ", bookingDateTime=" + getBookingdatetime()+", email=" + getEmail() + ", dinnertable = " + dinnertable + "]";
    }
    
}
