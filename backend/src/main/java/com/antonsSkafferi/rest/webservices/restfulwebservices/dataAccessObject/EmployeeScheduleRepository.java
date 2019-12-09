/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.EmployeeSchedule;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface EmployeeScheduleRepository extends JpaRepository<EmployeeSchedule,Integer> {
   
    @Query(value = "SELECT EMPLOYEEID FROM EMPLOYEE WHERE FNAME = ?1", nativeQuery = true)
    int getEmployee(String fname);
    
    @Query(value = "SELECT  WORKINGSCHEDULEID FROM WORKINGSCHEDULE WHERE DATE = ?1 AND START = ?2 AND END = ?3",  nativeQuery = true)
    Integer getWorkSchedule(String date, String start, String end);
    
}
