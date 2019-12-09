/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.TodaysLunchService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.TodaysLunch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodaysLunchController {
    
    @Autowired
    TodaysLunchService todaysLunchService = TodaysLunchService.getInstance();
    @RequestMapping(value = "/lunches")
    private List<TodaysLunch> getAllLunches() {
        return todaysLunchService.getAllLunches();
    }
    
    @PostMapping(value = "/post/todayslunch", params="todayslunch")
    private void saveTodayslunch(@RequestBody TodaysLunch todaysLunch){
        todaysLunchService.saveOrUpdateTodayslunch(todaysLunch);
    }
}
