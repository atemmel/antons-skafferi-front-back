/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.WorkingSchedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface WorkingScheduleRepository extends JpaRepository<WorkingSchedule,Integer> {
        
    @Query(value = "Select * from workingschedule where date like %?1%", nativeQuery = true)
    List<WorkingSchedule> scheduleDateTime(String date);
    
    @Query(value = "SELECT WORKINGSCHEDULEID FROM WORKINGSCHEDULE WHERE DATE = ?1 AND START = ?2 AND END = ?3", nativeQuery = true)
    int getScheduleIdByDateStartEnd(String date, String start, String end);
    
    @Query(value = "SELECT * FROM WORKINGSCHEDULE WHERE DATE = ?1 AND START = ?2 AND END = ?3",  nativeQuery = true)
    WorkingSchedule getWorkSchedule(String date, String start, String end);
    
    @Query(value = "SELECT EMPLOYEESCHEDULE.WORKINGSCHEDULEID FROM EMPLOYEESCHEDULE INNER JOIN WORKINGSCHEDULE ON EMPLOYEESCHEDULE.WORKINGSCHEDULEID = WORKINGSCHEDULE.WORKINGSCHEDULEID WHERE EMPLOYEESCHEDULE.EMPLOYEEID = ?1 AND WORKINGSCHEDULE.DATE = ?2", nativeQuery = true)
     List<Integer> getWorkScheduleByIdAndDate(int employeeid, String date);
}
