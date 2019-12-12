/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.classes.Request;
import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.EmployeeScheduleRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.WorkingScheduleRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.EmployeeSchedule;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.WorkingSchedule;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredriksellgren
 */
@Service
public class EmployeeScheduleService {
    
   @Autowired
   EmployeeScheduleRepository employeeScheduleRepository;
   @Autowired
   WorkingScheduleRepository workingScheduleRepository;
   
    
    private static EmployeeScheduleService employeeScheduleService;
    
    private EmployeeScheduleService(){};
    
    public static EmployeeScheduleService getInstance(){
        if(employeeScheduleService == null) {
            employeeScheduleService = new EmployeeScheduleService();
        }    
        return employeeScheduleService; 
    }
    
        //Get all EmployeeSchedules
    public List<EmployeeSchedule> getAllEmployeeSchedules(){
        List<EmployeeSchedule> empschedules = new ArrayList<>();
        employeeScheduleRepository.findAll().forEach(empschedule -> empschedules.add(empschedule));
        return empschedules;
    }
    
    public EmployeeSchedule getEmployeeScheduleById(int employee, int schedule){
        return employeeScheduleRepository.getEmployeeSchedule(employee, schedule);
    }
   
    public void postEmployeeSchedule(int employeeid, String date, String start, String end){
        
        WorkingSchedule tempWorkSchedule = workingScheduleRepository.getWorkSchedule(date, start, end);
        if(tempWorkSchedule != null)
        {
            EmployeeSchedule completeEmployeeSchedule = new EmployeeSchedule(employeeid,tempWorkSchedule.getWorkingscheduleid());
            employeeScheduleRepository.save(completeEmployeeSchedule);
        }
        
        else{
            workingScheduleRepository.save(new WorkingSchedule(date, start, end));
            WorkingSchedule temp1WorkSchedule = workingScheduleRepository.getWorkSchedule(date, start, end);
            EmployeeSchedule completeEmployeeSchedule = new EmployeeSchedule(employeeid,temp1WorkSchedule.getWorkingscheduleid());
            employeeScheduleRepository.save(completeEmployeeSchedule);
        }
        
    }
    
    public void switchEmployeeSchedule(String userOne, String userTwo, int scheduleIdOne, int scheduleIdTwo){
        
        EmployeeSchedule tempEmployeeOne = employeeScheduleRepository.getEmployeeSchedule(userOne, scheduleIdOne);
        EmployeeSchedule tempEmployeeTwo = employeeScheduleRepository.getEmployeeSchedule(userTwo, scheduleIdTwo);
        
        if(tempEmployeeOne == null) {
            System.out.println("Employee ẃith id " + userOne + " and scheduleId " + scheduleIdOne + " does not exist.");
            return;
        }
        
        if(tempEmployeeTwo == null) {
            System.out.println("Employee ẃith id " + userTwo + " and scheduleId " + scheduleIdTwo + " does not exist.");
            return;
        }
        
        int id1 = tempEmployeeOne.getEmployeeid();
        int id2 = tempEmployeeTwo.getEmployeeid();
        Request req = new Request(id1, id2, scheduleIdOne, scheduleIdTwo);
        
        if(RequestService.getInstance().addRequest(req)) {
    
            tempEmployeeOne.setEmployeeid(req.employeeId2);
            tempEmployeeTwo.setEmployeeid(req.employeeId1);
        
            employeeScheduleRepository.save(tempEmployeeOne);
            employeeScheduleRepository.save(tempEmployeeTwo);   
        }
    }
    
    public void deleteEmployeeSchedule(int employeeid, int workingscheduleid){
        EmployeeSchedule tempEmployeeScheduleId = employeeScheduleRepository.getEmployeeSchedule(employeeid, workingscheduleid);
        employeeScheduleRepository.deleteById(tempEmployeeScheduleId.getEmployeescheduleid());
    }
    
    public String getUserNameByWorkScheduleId(int workingscheduleid){
        return employeeScheduleRepository.getUserNameByWorkScheduleId(workingscheduleid);
    }
    
}
