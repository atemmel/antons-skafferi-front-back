/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dinnertable;
import com.antonsSkafferi.rest.webservices.restfulwebservices.services.DinnerTableService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class DinnerTableController {
    
    
    @Autowired
    DinnerTableService dinnerTableService;
    
    
    @GetMapping("/dinnertables")
    //Request GET
    private List<Dinnertable> getAllDinnerTables() throws SQLException, ClassNotFoundException {
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
    //@DeleteMapping("/dinnertables")
    //Request DELETE
    /*private void deleteAll(){
        dinnerTableService.deleteAll();
    }*/
    
   
    /*@PostMapping("/dinnertables")
    private int saveDinnerTable(@RequestBody Dinnertable dinnerTable){
        dinnerTableService.saveOrUpdate(dinnerTable);
        return dinnerTable.getDinnertableid();
    }*/
    
    
    
}
