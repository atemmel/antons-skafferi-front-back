/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;


import com.antonsSkafferi.rest.webservices.restfulwebservices.services.ItemCategoryService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.ItemCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class ItemCategoryController {
    @Autowired
    ItemCategoryService itemCategoryService = ItemCategoryService.getInstance();
        
    @RequestMapping(value = "/itemcategorys")
    private List<ItemCategory> getallItems(){
        return itemCategoryService.getAllItems();
    }   
    
    @RequestMapping(value = "/itemcategorys/itemcategory", params = "name")
    private List getItemCategoryByName(@RequestParam String name){
        return itemCategoryService.getItemCategoryByName(name);
    }
    
    @PostMapping(value = "/post/itemcategorys", params = "itemCategory")
    private void saveItemCategory(@RequestBody ItemCategory itemCategory){
        itemCategoryService.saveOrUpdateItemCategory(itemCategory);
    }
    
    @DeleteMapping("itemcategorys/delete/itemcategory")
    private void deleteItemCategory(@RequestParam int id){
        itemCategoryService.delete(id);
    }
    
    @DeleteMapping("itemcategorys/delete/all")
    private void deleteAll(){
        itemCategoryService.deleteAll();
    }
}
