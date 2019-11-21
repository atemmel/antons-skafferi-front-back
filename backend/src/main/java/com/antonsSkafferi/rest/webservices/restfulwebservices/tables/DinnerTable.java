
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DinnerTable implements Serializable {
    
    @Id
    private int id;
    private int sizeOfTable;
    private String description;
    @OneToOne(mappedBy ="dinnerTable")
    private Customer customer;
    

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

    /**
     * @return the size
     */
    public int getsizeOfTable() {
        return sizeOfTable;
    }

    /**
     * @param size the size to set
     */
    public void setsizeOfTable(int sizeOfTable) {
        this.sizeOfTable = sizeOfTable;
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
        return "DinnerTable [id=" + getId() + ", sizeOfTable=" + getsizeOfTable() + ", description=" + getDescription() + "]";
    }
}
