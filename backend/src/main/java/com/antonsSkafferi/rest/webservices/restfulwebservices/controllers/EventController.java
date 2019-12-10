/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.EventService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping(value = "/post/events", params="event")
    private void saveEvent(@RequestBody Event event){
        service.saveOrUpdateEvent(event);
    }
}
