package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.WorkingScheduleRepository;
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
public class WorkingScheduleService {
    
    @Autowired
    WorkingScheduleRepository workingScheduleRepository;
    
    private static WorkingScheduleService workingScheduleService;
    
    private WorkingScheduleService(){};
    
    public static WorkingScheduleService getInstance(){
        return workingScheduleService;
    }
    
    //Get all Schedules
    public List<WorkingSchedule> getAllSchedules(){
        List<WorkingSchedule> schedules = new ArrayList<>();
        workingScheduleRepository.findAll().forEach(schedule -> schedules.add(schedule));
        return schedules;
    }
    
    public List<WorkingSchedule> scheduleByDate(String time){
        List<WorkingSchedule> schedules = new ArrayList<>();
        workingScheduleRepository.scheduleDateTime(time).forEach(schedule -> schedules.add(schedule));
        return schedules;
    }
    public void saveOrUpdateSchedule(WorkingSchedule workingSchedule){
        
        workingScheduleRepository.save(workingSchedule);
    }
    
    public void deleteScheduleById(int sceduleid){
        workingScheduleRepository.deleteById(sceduleid);
    }
    
    public void deleteAll(){
        workingScheduleRepository.deleteAll();
    }
    public int getScheduleIdByDateStartEnd(String date, String start, String end){
        return workingScheduleRepository.getScheduleIdByDateStartEnd(date, start, end);
    }
            
}
