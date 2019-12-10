/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.EmployeeRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author willi
 */
@Service
public class EmployeeService {
  
    @Autowired
    EmployeeRepository employeeRepository;
    
    private static EmployeeService EmployeeService;
    
    public static EmployeeService getInstance(){
        return EmployeeService;
    }
    
        public int getEmployeeIdByName(String name)
    {
        return employeeRepository.getEmployeeIdByName(name);
    }
    
}
