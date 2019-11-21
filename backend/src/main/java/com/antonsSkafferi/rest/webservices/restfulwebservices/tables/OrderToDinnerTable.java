
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderToDinnerTable {
    
    @Id
    @Column(unique=true)
    private int id;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return "OrderToDinnerTable [id=" + getId() + "]";
    }
}
