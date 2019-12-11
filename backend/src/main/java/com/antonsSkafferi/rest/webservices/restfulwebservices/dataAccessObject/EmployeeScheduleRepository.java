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

    @Query(value = "SELECT * FROM EMPLOYEESCHEDULE WHERE employeeid = (SELECT EMPLOYEE.EMPLOYEEID FROM EMPLOYEE WHERE USERNAME = ?1) AND WORKINGSCHEDULEID = ?2", nativeQuery = true)
    EmployeeSchedule getEmployeeSchedule(String username, int scheduleid);
    
    @Query(value = "SELECT * FROM EMPLOYEESCHEDULE WHERE employeeid = ?1 AND workingscheduleid = ?2", nativeQuery = true)
    EmployeeSchedule getEmployeeScheduleDelete(int employeeid, int  workingscheduleid);
    
    @Query(value = "SELECT EMPLOYEE.USERNAME FROM EMPLOYEE INNER JOIN EMPLOYEESCHEDULE ON EMPLOYEE.EMPLOYEEID = EMPLOYEESCHEDULE.EMPLOYEEID WHERE WORKINGSCHEDULEID = ?1", nativeQuery = true)
    String getUserNameByWorkScheduleId(int workingscheduleid);
}
    