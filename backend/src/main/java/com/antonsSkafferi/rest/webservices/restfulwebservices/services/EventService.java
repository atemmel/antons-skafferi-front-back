/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.EventRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredriksellgren
 */
@Service
public class EventService {
    
    @Autowired
    EventRepository eventRepository;
    
    private static EventService EventService;
    
    public static EventService getInstance(){
        return EventService;
    }

    public void saveOrUpdateEvent(Event event) {
       eventRepository.save(event);
    }
    
    
    
            
}
