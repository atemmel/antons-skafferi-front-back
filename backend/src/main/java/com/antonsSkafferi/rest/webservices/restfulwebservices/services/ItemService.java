/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Item;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.ItemRepository;

/**
 *
 * @author willi
 */
@Service
public class ItemService {
    
    @Autowired
    ItemRepository itemRepository;
    
    private static ItemService ItemService;
    
    private ItemService(){};
    
    public static ItemService getInstance(){
        return ItemService;
    }
    
    
    //GET FUNCTIONS
    public List<Item> getAllItems()
    {
        
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(item -> items.add(item));
        
        return items; 
    }
    
    public List<Item> getItemsByTitle(String title)
    {
        List<Item> items = new ArrayList<>();
        itemRepository.itemFindByTitle(title).forEach(item -> items.add(item));
        return items;
    }
    
     public List getItemsByType(String type)
    {
        List<Item> items = new ArrayList<>();
        itemRepository.itemFindByType(type).forEach(item -> items.add(item));
        return items;
    }
    
     public List getItemsByDescription(String description)
     {
         List<Item> items = new ArrayList<>();
         itemRepository.itemFindByDescription(description).forEach(item -> items.add(item));
         return items;
     }
     
     public List getItemsByPrice(int price)
     {
         List<Item> items = new ArrayList<>();
         itemRepository.itemFindByPrice(price).forEach(item -> items.add(item));
         return items;
     }
    
    public void saveOrUpdateItem(Item item)
    {
        itemRepository.save(item);
    }
    
    public void delete(int id)
    {
        itemRepository.deleteById(id);
    }
    
    public void deleteAll()
    {
        itemRepository.deleteAll();
    }
    
        //This is for listing the customers that visiting the resturang today, and make the resault to a JSON object. 
    
}
