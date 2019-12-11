/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.EmployeeScheduleService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.EmployeeSchedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeScheduleController {
    
    
    @Autowired
    EmployeeScheduleService service = EmployeeScheduleService.getInstance();
    
    @RequestMapping(value = "/empschedules")
    //Request GET
    private List<EmployeeSchedule> getAllEmployeeWorkingSchedule(){
       return service.getAllEmployeeSchedules();
    }
    
    @PostMapping(value = "/empschedules/post/employeesechedual",  params = {"employeeid","date", "start", "end"})
    private void setEmployeeSchedual(@RequestParam int employeeid, String date, String start, String end){
        service.postEmployeeSchedule(employeeid, date, start, end);
    }
 
    @PostMapping(value = "/empschedules/post/switchemployeesecheduals", params = {"userone","usertwo","scheduleone","scheduletwo"})
    private void switchEmployeeSchedualId(@RequestParam String userOne, String userTwo, int scheduleone, int scheduletwo){
        service.switchEmployeeSchedule(userOne, userTwo, scheduleone, scheduletwo);
    }
    
    @DeleteMapping(value = "/empschedules/delete/employeesechedual", params = {"employeeid", "workscheduleid"})
    private void deleteEmployeeSchedule(@RequestParam int employeeid, int workscheduleid){
        service.deleteEmployeeSchedule(employeeid, workscheduleid);
    }
    
    
    @RequestMapping(value="/empschedules/username", params= "workscheduleid")
    private String x(@RequestParam int workscheduleid){
        return service.getUserNameByWorkScheduleId(workscheduleid);
    }
    
}
