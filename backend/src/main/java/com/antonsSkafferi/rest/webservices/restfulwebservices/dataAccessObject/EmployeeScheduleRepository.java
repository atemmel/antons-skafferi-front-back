/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.EmployeeSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface EmployeeScheduleRepository extends JpaRepository<EmployeeSchedule,Integer> {
    
@Query(value= "INSERT INTO EMPLOYEESCHEDULE (EMPLOYEESCHEDULEID,EMPLOYEEID,WORKINGSCHEDULEID) VALUES ((SELECT EMPLOYEEID FROM EMPLOYEE WHERE FNAME = ?1),(SELECT WORKINGSCHEDULEID FROM WORKINGSCHEDULE WHERE DATE = ?2 AND START = ?3 AND END = ?4));;", nativeQuery = true)
EmployeeSchedule setEmployeeSchedule(String name, String date, String start, String end);
    
}
