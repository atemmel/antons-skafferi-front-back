/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.controllers.ConnectionManager;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dish;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.DishRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fredriksellgren
 */
@Service
public class DishService {
    
    @Autowired
    DishRepository dishRepository;
    
    @Bean
    public CommandLineRunner initItems(DishRepository itemRepository) {
        return (args) -> {
            
            dishRepository.save(new Dish("Bakad fläskkarre",115,"gräddstuvad kål, senapssky, äppelmos, rostad morot","kött"));
            dishRepository.save(new Dish("Oxbringa",115,"senapssås, pepparrot, rostad potatis, bakad lök, persilja","kött"));
            dishRepository.save(new Dish("Fiskgryta",145,"sej, musslor, potatis, fänkål, dill, citron, aioli","fisk​"));
            dishRepository.save(new Dish("Tomatsoppa",115,"Ägg 63, chili, krutonger, basilika​","vegetarisk"));
            dishRepository.save(new Dish("Viltpannbiffar",115,"löksås, syrad gurka, potatispure","kött"));
            dishRepository.save(new Dish("Grillad lammytter",115,"Basmatiris, Rogan Josh, paprika, chili, koriander, tomatsallad","kött"));
        }; 

    }
    
    
    
    public List<Dish> getAllItems()
    {
        
        List<Dish> items = new ArrayList<Dish>();
        dishRepository.findAll().forEach(item -> items.add(item));
        
        return items; 
    }
    
    public Dish getItemsByTitle(String title)
    {
        return dishRepository.findById(title).get();
    }
    
    public void saveOrUpdateItem(Dish item)
    {
        dishRepository.save(item);
    }
    
    public void delete(String title)
    {
        dishRepository.deleteById(title);
    }
    
        //This is for listing the customers that visiting the resturang today, and make the resault to a JSON object. 
    public List getDishesType(String type)
    {
        
        
        Map json = new HashMap(); 
        List contentList = new ArrayList();
        
        //create connection for a server installed in localhost, with a user "root" with no password
        try (Connection conn = ConnectionManager.getConnection()){
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                try (ResultSet resultSet = stmt.executeQuery("SELECT*From Dish where TYPE LIKE '"+ type+"%'")) {
                    //get the result from the executed query
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    System.out.println(resultSetMetaData);
  

                    //Finding the Colomn name inside the database and the data inside, parse them to map, then everything to a list == JSON
                    while(resultSet.next()){
                        Map<String,Object> columnMap = new HashMap<String, Object>();
                        
                        
                        for(int columnIndex=1; columnIndex <= resultSetMetaData.getColumnCount(); columnIndex++){
                            System.out.println(resultSetMetaData.getColumnName(columnIndex));
                            if(resultSet.getString(resultSetMetaData.getColumnName(columnIndex)) != null)
              
                                columnMap.put(resultSetMetaData.getColumnLabel(columnIndex).toLowerCase(),resultSet.getString(resultSetMetaData.getColumnName(columnIndex)));    
                            else
                                columnMap.put(resultSetMetaData.getColumnLabel(columnIndex), "");
                        }
                            contentList.add(columnMap);
                    }
                } catch (SQLException e){
                        e.printStackTrace();
                }
                json.put("Customer", contentList);
                return (ArrayList<String>) contentList;
            } 
        } catch(SQLException e ){
                e.printStackTrace();
            }
        return null;
    }
    
    
    
}
