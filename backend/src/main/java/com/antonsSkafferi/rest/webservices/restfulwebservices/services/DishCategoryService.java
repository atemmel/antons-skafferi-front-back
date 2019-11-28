/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.DishCategoryRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.DishCategory;
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
public class DishCategoryService {
    @Autowired
    DishCategoryRepository dishCategoryRepository;
    
    @Bean
    public CommandLineRunner initDishCategory(DishCategoryRepository dishCategoryRepository) {
        return (args) -> {
            
            dishCategoryRepository.save(new DishCategory(1,"Kött","url"));
            dishCategoryRepository.save(new DishCategory(2,"Förrätt","url"));
            dishCategoryRepository.save(new DishCategory(3,"Efterrätt","url"));
            dishCategoryRepository.save(new DishCategory(4,"Kockens Val","url"));
            dishCategoryRepository.save(new DishCategory(5,"Vilt","url"));
            dishCategoryRepository.save(new DishCategory(6,"À La Carte","url"));
            dishCategoryRepository.save(new DishCategory(7,"Dryck","url"));
        }; 

    }
    
    public List<DishCategory> getAllItems()
    {
        
        List<DishCategory> items;
        items = new ArrayList<>();
        dishCategoryRepository.findAll().forEach(item -> items.add(item));
        
        return items; 
    }
}
