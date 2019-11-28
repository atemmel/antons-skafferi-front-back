/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.ItemService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Item;
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
public class ItemController {
    
    @Autowired
    ItemService itemService;
    
    @GetMapping("/items")
    private List<Item> getallItems(){
        return itemService.getAllItems();
    }
    
    @GetMapping("/items/{title}")
    private Item getItem(@PathVariable("title") String title){
        System.out.println(title);
        return itemService.getItemsByTitle(title);

    }
            
}
