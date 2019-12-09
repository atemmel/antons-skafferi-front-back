/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer>  {
    
    @Query(value = "SELECT EMPLOYEEID FROM EMPLOYEE WHERE FNAME = ?1", nativeQuery = true)
    int getEmployeeIdByName(String employeeName);
}
