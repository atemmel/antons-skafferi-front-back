/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.TodaysLunchRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.TodaysLunch;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class TodaysLunchService {
    
    @Autowired
    TodaysLunchRepository todaysLunchRepository;
    
    private static TodaysLunchService TodaysLunchService;
    
    private TodaysLunchService(){};
    
    public static TodaysLunchService getInstance(){
        return TodaysLunchService;
    }
    
    public List<TodaysLunch> getAllLunches()
    {
        List<TodaysLunch> lunches = new ArrayList<>();
        todaysLunchRepository.findAll().forEach(todaysLunch -> lunches.add(todaysLunch));
        return lunches;
    }
    
    public void saveOrUpdateTodayslunch(TodaysLunch todaysLunch){
        todaysLunchRepository.save(todaysLunch);
    }
    
}
