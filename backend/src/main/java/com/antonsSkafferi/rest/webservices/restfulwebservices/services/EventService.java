/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.EventRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Event;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

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
    public void createEvent(String date) throws FileNotFoundException, IOException{
        System.out.println(date);
        new File("../"+date).mkdirs();
        File file = ResourceUtils.getFile("../"+date);
        
        if(file.exists()){
           File temp = new File("../"+date+"/testar.png");
           //Create the file
           if (temp.createNewFile()){
             System.out.println("File is created!");
           }else{
             System.out.println("File already exists.");
           }
        }
        
    }
}
