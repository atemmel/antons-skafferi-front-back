/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.classes.Request;
import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.EmployeeScheduleRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.EmployeeSchedule;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ninhow
 */
public class RequestService {
    
    @Autowired
    EmployeeScheduleRepository employeeScheduleRepository;
    
       
    ArrayList<Request> requests = new ArrayList<>();
    
    private static RequestService requestService;
    
    private RequestService(){
    };
    
    
    public static RequestService getInstance(){
        if(requestService == null) {
            requestService = new RequestService();
        }    
        return requestService; 
    }
    
    public boolean addRequest(Request request) {
        int index = requests.indexOf(request);
        if(index != -1) {   
           //Om requesten redan existerar
            requests.remove(index);
            return true;
        } 
        
        //Annars läggs den till
        requests.add(request);
        
        return false;
    }
    
    
    public void clearRequests() {
        requests.clear();
    }
}
