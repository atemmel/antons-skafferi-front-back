/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

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
        return employeeScheduleService;
    }
    
        //Get all EmployeeSchedules
    public List<EmployeeSchedule> getAllEmployeeSchedules(){
        List<EmployeeSchedule> empschedules = new ArrayList<>();
        employeeScheduleRepository.findAll().forEach(empschedule -> empschedules.add(empschedule));
        return empschedules;
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
        
        int tempEmployeeOneId = tempEmployeeOne.getEmployeeid();
        int tempEmployeeTwoId = tempEmployeeTwo.getEmployeeid();
        
        tempEmployeeOne.setEmployeeid(tempEmployeeTwoId);
        tempEmployeeTwo.setEmployeeid(tempEmployeeOneId);
        
        employeeScheduleRepository.save(tempEmployeeOne);
        employeeScheduleRepository.save(tempEmployeeTwo);    
    }
    
    public void deleteEmployeeSchedule(int employeeid, int workingscheduleid){
        EmployeeSchedule tempEmployeeScheduleId = employeeScheduleRepository.getEmployeeScheduleDelete(employeeid, workingscheduleid);
        
        employeeScheduleRepository.deleteById(tempEmployeeScheduleId.getEmployeescheduleid());
    }
    
    public String getUserNameByWorkScheduleId(int workingscheduleid){
        return employeeScheduleRepository.getUserNameByWorkScheduleId(workingscheduleid);
    }
    
}
