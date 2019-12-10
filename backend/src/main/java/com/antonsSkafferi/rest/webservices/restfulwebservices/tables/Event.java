package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author willi
 */

@Entity
@Table(name="event")
public class Event {
    
    @Column(name="title", updatable = true, nullable = true)
    private String title;
    
    @Id
    @Column(name="eventdate", updatable = true, nullable = true)
    private String eventdate;
    
    @Column(name="picture", updatable = true, nullable = true)
    private String picture;
    
    public Event(){}
    
    public Event(String title, String eventdate, String picture){
        this.title = title;
        this.eventdate = eventdate;
        this.picture = picture;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the eventdate
     */
    public String getEventdate() {
        return eventdate;
    }

    /**
     * @param eventdate the eventdate to set
     */
    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    @Override
    public String toString(){
        return "Event [title=" + getTitle() + ", eventdate="+ getEventdate() + ", picture=" + getPicture() + "]";
    }
}
