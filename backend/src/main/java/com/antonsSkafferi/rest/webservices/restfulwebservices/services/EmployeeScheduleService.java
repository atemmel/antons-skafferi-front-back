/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.EmployeeScheduleRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.EmployeeSchedule;
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
    
}
