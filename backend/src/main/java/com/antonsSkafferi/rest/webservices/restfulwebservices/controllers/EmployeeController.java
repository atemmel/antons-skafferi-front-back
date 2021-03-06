/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.EmployeeService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService service = EmployeeService.getInstance();
    
    //Get Requests
    @RequestMapping(value = "/employees")
    //Request GET
    private List<Employee> getAllEmployees(){
       return service.getAllEmployees();
    }
    
    @RequestMapping(value = "/employees", params= "name")
    private int getEmployeeIdByName(@RequestParam String name){
        return service.getEmployeeIdByName(name);
    }
}
