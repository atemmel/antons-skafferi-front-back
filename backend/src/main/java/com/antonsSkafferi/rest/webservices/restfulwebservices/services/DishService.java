/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

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
    
    private static DishService DishService;
    
    private DishService(){};
    
    public static DishService getInstance(){
        return DishService;
    }
    
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
    
    //GET FUNCTIONS
    public List<Dish> getAllDishes()
    {
        
        List<Dish> dishes = new ArrayList<>();
        dishRepository.findAll().forEach(dish -> dishes.add(dish));
        
        return dishes; 
    }
    
    public List<Dish> getDishesByTitle(String title)
    {
        List<Dish> dishes = new ArrayList<Dish>();
        dishRepository.dishFindByTitle(title).forEach(dish -> dishes.add(dish));
        return dishes;
    }
    
     public List getDishesByType(String type)
    {
        List<Dish> dishes = new ArrayList<Dish>();
        dishRepository.dishFindByType(type).forEach(dish -> dishes.add(dish));
        return dishes;
    }
    
     public List getDishesByDescription(String description)
     {
         List<Dish> dishes = new ArrayList<Dish>();
         dishRepository.dishFindByDescription(description).forEach(dish -> dishes.add(dish));
         return dishes;
     }
     
     public List getDishesByPrice(int price)
     {
         List<Dish> dishes = new ArrayList<Dish>();
         dishRepository.dishFindByPrice(price).forEach(dish -> dishes.add(dish));
         return dishes;
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
   
    
    
    
}
