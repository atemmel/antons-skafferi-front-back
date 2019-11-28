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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class ItemCategoryController {
    @Autowired
    ItemCategoryService itemCategoryService;
        
    @GetMapping("/itemCategory")
    private List<ItemCategory> getallItems(){
        return itemCategoryService.getAllItems();
    }   
}
