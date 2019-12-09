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

public interface WorkingScheduleRepository extends JpaRepository<WorkingSchedule,Integer> {
        
    @Query(value = "Select * from workingschedule where date like %?1%", nativeQuery = true)
    List<WorkingSchedule> scheduleDateTime(String date);
    
    
}