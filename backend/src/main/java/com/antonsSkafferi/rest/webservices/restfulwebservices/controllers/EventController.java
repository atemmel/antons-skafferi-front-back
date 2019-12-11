/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.filetransformation.CodecBase64;
import com.antonsSkafferi.rest.webservices.restfulwebservices.services.EventService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Event;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EventController {
    
    @Autowired
    EventService service = EventService.getInstance();
    
    @RequestMapping(value = "/events")
    private List<Event> getAllEvents(){
        return service.findAll();
    }
    
    @RequestMapping(value = "/events/event", params="date")
    private Event getEvent(@RequestParam String date){
        return service.getEvent(date);
    }
    
    @PostMapping(value = "/post/events", params="event")
    private void saveEvent(@RequestBody Event event){
        service.saveOrUpdateEvent(event);
    }
    
    
    @PostMapping(value = "/post/event", params={"date"})
    private void newEvent(@RequestParam String date) throws IOException{
        System.out.println("\n HEJ HEJ från /post/event");
        //service.createEvent(date);
    }
    
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public ResponseEntity<Bild> image(@RequestBody Bild payload) throws Exception {
       //System.out.println((String)payload.get("myMap"));
       
       //service.saveOrUpdateEvent(new Event(new String(payload.)));
         //System.out.println(payload.getTitle());
         //System.out.println(payload.getDate());
         //System.out.println(payload.getImageName());
         //System.out.println(Arrays.toString(payload.getImage()));
         
        //Skapa Event
        service.createEvent(payload.getTitle(),payload.getDate(), payload.getImage(), payload.getImageName());
         
         //CodecBase64.writeByteArraysToFile(new String(payload.getImageName()), payload.getImage(), payload.getDate());
        //System.out.println(payload.getImage());
        //CodecBase64.decode(payload.getImage(), payload.getImageName());
        
        return new ResponseEntity<Bild>(payload, HttpStatus.OK);
    }
}
