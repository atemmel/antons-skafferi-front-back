
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

@Entity
public class Customer implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Europe/Berlin")
    private Timestamp bookingDateTime;
    
    private String name;
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="dinnerTable_id", referencedColumnName = "id")
    private DinnerTable dinnerTable;
    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    /*public void setId(int id) {
        this.id = id;
    }*/

    
    /**
     * @return the bookingDateTime
     */
    public Timestamp getBookingDateTime() {
        return bookingDateTime;
    }

    /**
     * @param bookingDateTime the bookingDateTime to set
     */
    public void setBookingDateTime(Timestamp bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
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
    
    @Override
    public String toString(){
        return "Customer [id=" + getId() + ", name=" + getName() + ", email=" + getEmail() + ", bookingDateTime=" + getBookingDateTime()+"]";
    }
    
}
