
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.EventRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.filetransformation.CodecBase64;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Event;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    public Event getEvent(String date){
        return eventRepository.findEvent(date);
    }
    public void createEvent(String title, String date, byte[] content, String fileName) throws FileNotFoundException, IOException{
        System.out.println(date);
        new File("../backend/src/main/resources/images/"+date).mkdirs();
        
        if((ResourceUtils.getFile("../backend/src/main/resources/images/"+date).exists())){
            CodecBase64.writeByteArraysToFileFolder(fileName, content, date);
            Event tmp = new Event(title, date, "../backend/src/main/resources/images/"+ date + "/" +fileName+".jpeg");
            
            System.out.println("Title: " + tmp.getTitle() + "Date: " + tmp.getEventdate() + "Path: " + tmp.getPicture());
            eventRepository.save(tmp);
           //File temp = new File("../backend/src/main/resources/images/"+date+"/testar.png");
           //CodecBase64.writeByteArraysToFile(new String(payload.getImageName()), payload.getImage(), payload.getDate());
            //Create the file
           //if (temp.createNewFile()){
            // System.out.println("File is created!");
           //}else{
             //System.out.println("File already exists.");
           //}
        }
        
    }
    
    
}
