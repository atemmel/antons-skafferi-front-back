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
    
    EmployeeScheduleService service = new EmployeeScheduleService();
       
    ArrayList<Request> requests = new ArrayList<>();
    
    private static RequestService requestService;
    
    private RequestService(){
        requestService = new RequestService();
    };
    
    
    public static RequestService getInstance(){
        if(requestService == null) {
            requestService = new RequestService();
        }
        
        return requestService; 
    }
    
    public void addRequest(Request request) {
        int index = requests.indexOf(request);
        if(index != -1) {   
            //Om requesten redan existerar
            Request tmp = requests.get(index);
            EmployeeSchedule tempEmployeeOne = service.getEmployeeScheduleById(tmp.employeeId1, tmp.scheduleId1);
            EmployeeSchedule tempEmployeeTwo = service.getEmployeeScheduleById(tmp.employeeId2, tmp.scheduleId2);
               
            tempEmployeeOne.setEmployeeid(tmp.employeeId2);
            tempEmployeeTwo.setEmployeeid(tmp.employeeId1);
        
            employeeScheduleRepository.save(tempEmployeeOne);
            employeeScheduleRepository.save(tempEmployeeTwo);   

        } else {    
            //Annars läggs den till
            requests.add(request);
        }
    }
    
    
    public void clearRequests() {
        requests.clear();
    }
}
