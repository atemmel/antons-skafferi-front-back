
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author fredriksellgren
 */


@Entity
@Table(name="dinnertable")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dinnertable implements Serializable {
    
    @Id
    @Column(name = "dinnertableid", updatable = false, nullable = false)
    private int dinnertableid;
    //We dont want the dinnertables values to change when we are running, change them on init instead.
    @Column(name = "sizesoftable", updatable = false, nullable = false)
    private int sizesoftable;
    @Column(name = "description", updatable = false, nullable = false)
    private String description;
    //What the relation is mapped to customer <-- One to One --> dinnertables.
    //@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "dinnertable")
    //private Customer customer;
    

    public Dinnertable(){}
    
    //We only wanna post what table the customer is going to be using at the resturang.
    public Dinnertable(int dinnertableid){
    
        this.dinnertableid = dinnertableid;
    
    }
    //maybe redudant dunno yet.
    public Dinnertable(int dinnertableid, String description, int sizeoftable){
        this.dinnertableid = dinnertableid;
        this.description = description;
        this.sizesoftable = sizeoftable;
    
    
    }
    
    /**
     * @return the dinnertableid
     */
    public int getDinnertableid() {
        return dinnertableid;
    }

    /**
     * @param dinnertableid the dinnertableid to set
     */
    public void setDinnertableid(int dinnertableid) {
        this.dinnertableid = dinnertableid;
    }

    /**
     * @return the size
     */
    public int getsizeOfTable() {
        return sizesoftable;
    }

    /**
     * @param size the size to set
     */
    public void setsizeOfTable(int sizeOfTable) {
        this.sizesoftable = sizeOfTable;
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
        return "Dinnertable [dinnertableid=" + getDinnertableid() + ", sizeOfTable=" + getsizeOfTable() + ", description=" + getDescription() + "]";
    }
}
