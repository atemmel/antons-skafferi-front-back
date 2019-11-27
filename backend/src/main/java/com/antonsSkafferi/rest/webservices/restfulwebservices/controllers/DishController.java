/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.DishService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dish;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class DishController {
    
    @Autowired
    DishService dishService;
    
    @GetMapping("/dish")
    private List<Dish> getallItems(){
        return dishService.getAllItems();
    }
    
    @GetMapping("/dish/{title}")
    private Dish getItem(@PathVariable("title") String title){
        System.out.println(title);
        return dishService.getItemsByTitle(title);

    }
    
    /*@GetMapping("dish/type/{type}")
    private List getDishesType(@PathVariable("type") String type){
         return dishService.getDishesType(type);
    }*/
            
}
