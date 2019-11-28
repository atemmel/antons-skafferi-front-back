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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class DishController {
    
    @Autowired
    DishService dishService = DishService.getInstance();
    
    @RequestMapping(value = "/dishes")
    private List<Dish> getallDishes(){
        return dishService.getAllDishes();
    }
    
    @RequestMapping(value = "/dishes/dish", params = "title")
    private List getDishesTitle(@RequestParam String title){
        return dishService.getDishesByTitle(title);
    }
    

    @RequestMapping(value = "/dishes/dish", params = "type")
    private List getDishesType(@RequestParam String type){
         return dishService.getDishesByType(type);
    }
    
    @RequestMapping(value = "/dishes/dish", params = "description")
    private List getDishesDescription(@RequestParam String description){
        return dishService.getDishesByDescription(description);
    }
    
    @RequestMapping(value = "/dishes/dish", params = "price")
    private List getDishesPrice(@RequestParam int price){
        return dishService.getDishesByPrice(price);
    }
            
}
