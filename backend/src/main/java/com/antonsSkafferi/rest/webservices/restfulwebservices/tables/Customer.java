
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
    
    @Column(name="bookingtime", updatable=true, nullable=false)
    private String bookingtime;
    @Column(name="bookingdate", updatable=true, nullable=false)
    private String bookingdate;
    @Column(name = "firstname", updatable = true, nullable = false)
    private String firstname;
    @Column(name="lastname", updatable = true, nullable = false)
    private String lastname;
    
    @Column(name = "email", updatable = true, nullable = false)
    private String email;
    
    @Column(name ="phone", updatable = true, nullable = false)
    private String phone;
    
    @Column(name = "sizeofcompany", updatable = true, nullable = false)
    private int sizeofcompany;
    
    @ManyToOne(fetch = FetchType.LAZY /*,optional = false*/)
    @JoinColumn(name = "dinnertableid", nullable = true)
    private Dinnertable dinnertable;
    
    //@Column(name = "dinnertableid", updatable = true, nullable = true)
    //private int dinnertableid;
    
    
    public Customer(){};
    
    public Customer(int customerid, String firstname, String lastname, int sizeofcompany, String email, String bookingtime, String bookingdate, String phone){
    
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.bookingtime = bookingtime;
        this.bookingdate = bookingdate;
        this.sizeofcompany = sizeofcompany;
        this.phone = phone;
        
    }
    
    /* We need to check whats wrong whit this, you nolonger cant post a customer whit null table
   public Customer(int customerid, String firstname, String lastname, int sizeofcompany, String email, String bookingtime, String bookingdate, int dinnertableid, String phone){
    
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.bookingtime = bookingtime;
        this.bookingdate = bookingdate;
        this.sizeofcompany = sizeofcompany;
        //this.dinnertableid = dinnertableid;
        this.phone = phone;
    }*/
    
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
     * @return the sizeofcompany
     */
    public int getSizeofcompany() {
        return sizeofcompany;
    }
    
        /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @param sizeofcompany the sizeofcompany to set
     */
    public void setSizeofcompany(int sizeofcompany) {
        this.sizeofcompany = sizeofcompany;
    }
    
        /**
     * @return the bookingdatetime
     */
    public String getBookingtime() {
        return bookingtime;
    }
    
    /**
     * @param bookingtime the bookingdatetime to set
     */
    public void setBookingtime(String bookingtime) {
        this.bookingtime = bookingtime;
    }
    
      /**
     * @return the date
     */
    public String getBookingdate() {
        return bookingdate;
    }

    /**
     * @param bookingdate the date to set
     */
    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
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
     * @param dinnertableid the dinnertableid to set
     */
    /*public void setDinnertableid(int dinnertableid) {
        this.dinnertableid = dinnertableid;
    }*/
    
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
        return "Customer [customerid=" + getCustomerid() + ", firstname=" + getFirstname() + ", lastname=" + getLastname() + ", sizeofcompany=" + getSizeofcompany() + ", bookingdate= " + getBookingdate() + ", bookingtime=" + getBookingtime()+", email=" + getEmail() + ", phone=" + getPhone()+ ", dinnertable = " + dinnertable + "]";
    }
    
}
