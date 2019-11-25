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
import org.springframework.stereotype.Service;

/**
 *
 * @author fredriksellgren
 */
@Service
public class DinnerTableService {
    
    @Autowired
    DinnerTableRepository dinnerTableRepository;
    
    public List<Dinnertable> getAllDinnerTables()
    {
        
        List<Dinnertable> dinnerTables = new ArrayList<Dinnertable>();
        dinnerTableRepository.findAll().forEach(dinnerTable -> dinnerTables.add(dinnerTable));
        
        return dinnerTables; 
    }
    
    public Dinnertable getDinnerTablesById(int id){
        
        return dinnerTableRepository.findById(id).get();
    }
    
    public void saveOrUpdate(Dinnertable dinnerTable){
    
        dinnerTableRepository.save(dinnerTable);
    }
    
    
    public void delete(int id){
        
        dinnerTableRepository.deleteById(id);
    }
    
    public void deleteAll(){
    
        dinnerTableRepository.deleteAll();
    }
}
