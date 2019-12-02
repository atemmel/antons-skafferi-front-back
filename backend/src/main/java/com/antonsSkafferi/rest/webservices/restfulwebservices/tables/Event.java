package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author willi
 */

@Entity
@Table(name="event")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="eventid", updatable = false, nullable = false)
    private int eventid;
    
    @Column(name="title", updatable = true, nullable = true)
    private String title;
    
    @Column(name="eventdate", updatable = true, nullable = true)
    private String eventdate;
    
    @Column(name="eventtime", updatable = true, nullable = true)
    private String eventtime;
    
    @Column(name="picture", updatable = true, nullable = true)
    private String picture;
    
    public Event(){}
    
    public Event(int eventid, String title, String eventdate, String eventtime, String picture){
        this.eventid = eventid;
        this.title = title;
        this.eventdate = eventdate;
        this.eventtime = eventtime;
        this.picture = picture;
    }
    
    /**
     * @return the eventid
     */
    public int getEventid() {
        return eventid;
    }

    /**
     * @param eventid the eventid to set
     */
    public void setEventid(int eventid) {
        this.eventid = eventid;
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
     * @return the eventtime
     */
    public String getEventtime() {
        return eventtime;
    }

    /**
     * @param eventtime the eventtime to set
     */
    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
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
        return "Event [eventid=" + getEventid() + ", title=" + getTitle() + ", eventdate="+ getEventdate() + ", eventtime=" + getEventtime() + ", picture=" + getPicture() + "]";
    }
}
