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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author willi
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ItemController {
    
    @Autowired
    ItemService itemService = ItemService.getInstance();
    
    @RequestMapping(value = "/items")
    private List<Item> getallItems(){
        return itemService.getAllItems();
    }
    
    @RequestMapping(value = "/items/item", params = "title")
    private List getItemsTitle(@RequestParam String title){
        return itemService.getItemsByTitle(title);
    }
    

    @RequestMapping(value = "/items/item", params = "type")
    private List getItemsType(@RequestParam String type){
         return itemService.getItemsByType(type);
    }
    
    @RequestMapping(value = "/items/item", params = "description")
    private List getItemsDescription(@RequestParam String description){
        return itemService.getItemsByDescription(description);
    }
    
    @RequestMapping(value = "/items/item", params = "price")
    private List getItemsPrice(@RequestParam int price){
        return itemService.getItemsByPrice(price);
    }
    
    //Post function
    @PostMapping(value = "/post/items", params="item")
    private void saveItem(@RequestBody Item item){
        itemService.saveOrUpdateItem(item);
    }
    
    //Delete functions
    @DeleteMapping("/items/delete/item")
    private void deleteItem(@RequestParam int id){
        itemService.delete(id);
    }
    
    @DeleteMapping("/items/delete/all")
    private void deleteAll(){
        itemService.deleteAll();
    }
            
}
