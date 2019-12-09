/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.DinnerTableService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dinnertable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DinnerTableController {
    
    
    @Autowired
    DinnerTableService dinnerTableService = DinnerTableService.getInstance();
    
    
    @GetMapping("/dinnertables")
    //Request GET
    private List<Dinnertable> getAllDinnerTables(){
        return dinnerTableService.getAllDinnerTables();
    }
    
    @GetMapping("/dinnertables/{id}")
    //Request GET
    private Dinnertable getTable(@PathVariable("id") int id){
        return dinnerTableService.getDinnerTablesById(id);
    }
    
    @DeleteMapping("/dinnertables/{id}")
    //Request DELETE
    private void deleteDinnerTable(@PathVariable("id") int id){
        dinnerTableService.delete(id);
    }
    
    @RequestMapping(value = "/dinnertables/booking", params="date")
    private List getAllUnbookedTables(@RequestParam String date){
        return dinnerTableService.getAllUnbookedTables(date);
    }
    
    //@DeleteMapping("/dinnertables")
    //Request DELETE
    /*private void deleteAll(){
        dinnerTableService.deleteAll();
    }*/
    
   
    /*@PostMapping("/dinnertables")
    private int saveDinnerTable(@RequestBody Dinnertable dinnerTable){
        dinnerTableService.saveOrUpdateDinnerTable(dinnerTable);
        return dinnerTable.getDinnertableid();
    }*/
    
    
    @PostMapping(value = "/post/active/true", params="dinnertable")
    private void setActiveTrue(@RequestParam int dinnertable){
        dinnerTableService.setActiveTrue(dinnertable);
    }
    
    @PostMapping(value = "/post/active/false", params="dinnertable")
    private void setActiveFalse(@RequestParam int dinnertable){
        dinnerTableService.setActiveFalse(dinnertable);
    }
    
    @RequestMapping(value = "/dinnertables/active", params="dinnertable")
    private boolean checkActive(@RequestParam int dinnertable){
       return dinnerTableService.checkActive(dinnertable);
    }
}
