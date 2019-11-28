/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.DinnerTableRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dinnertable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredriksellgren
 */
@Service
public class DinnerTableService {
    
    @Autowired
    DinnerTableRepository dinnerTableRepository;
    
    @Bean
    public CommandLineRunner initDinnerTables(DinnerTableRepository dinnertablerepository) {
        return (args) -> {
            
            dinnertablerepository.save(new Dinnertable(1,"Fonsterbord",4));
            dinnertablerepository.save(new Dinnertable(2,"Fonsterbord",4));
            dinnertablerepository.save(new Dinnertable(3,"Fonsterbord",4));
            dinnertablerepository.save(new Dinnertable(4,"Langbord",12));
            dinnertablerepository.save(new Dinnertable(5,"Langbord",12));
            dinnertablerepository.save(new Dinnertable(6,"Langbord",12));
        }; 

    }
    
    public List<Dinnertable> getAllDinnerTables()
    {

        List<Dinnertable> dinnerTables = new ArrayList<>();
        dinnerTableRepository.findAll().forEach(dinnerTable -> dinnerTables.add(dinnerTable));
        
        return dinnerTables; 
    }
    
    public Dinnertable getDinnerTablesById(int id){
        
        return dinnerTableRepository.findById(id).get();
    }
    
    public void saveOrUpdateDinnerTable(Dinnertable dinnerTable){
    
        dinnerTableRepository.save(dinnerTable);
    }
    
    
    public void delete(int id){
        
        dinnerTableRepository.deleteById(id);
    }
    
    public void deleteAll(){
    
        dinnerTableRepository.deleteAll();
    }
}
