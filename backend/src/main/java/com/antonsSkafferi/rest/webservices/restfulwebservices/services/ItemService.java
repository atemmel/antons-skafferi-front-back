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
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author fredriksellgren
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
    
    @Bean
    public CommandLineRunner initItem(ItemRepository itemRepository) {
        return (args) -> {
            
            itemRepository.save(new Item(1,"Bakad fläskkarre",115,"gräddstuvad kål, senapssky, äppelmos, rostad morot","kött"));
            itemRepository.save(new Item(2,"Oxbringa",115,"senapssås, pepparrot, rostad potatis, bakad lök, persilja","kött"));
            itemRepository.save(new Item(3,"Fiskgryta",145,"sej, musslor, potatis, fänkål, dill, citron, aioli","fisk​"));
            itemRepository.save(new Item(4,"Tomatsoppa",115,"Ägg 63, chili, krutonger, basilika​","vegetarisk"));
            itemRepository.save(new Item(5,"Viltpannbiffar",115,"löksås, syrad gurka, potatispure","kött"));
            itemRepository.save(new Item(6,"Grillad lammytter",115,"Basmatiris, Rogan Josh, paprika, chili, koriander, tomatsallad","kött"));
        }; 
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
