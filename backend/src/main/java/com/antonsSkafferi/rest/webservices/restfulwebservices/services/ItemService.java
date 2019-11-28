/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.ItemRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Item;
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
public class ItemService {
    
    @Autowired
    ItemRepository itemRepository;
    
    @Bean
    public CommandLineRunner initItems(ItemRepository itemRepository) {
        return (args) -> {
            
            itemRepository.save(new Item("Bakad fläskkarre",115,"gräddstuvad kål, senapssky, äppelmos, rostad morot"));
            itemRepository.save(new Item("Oxbringa",115,"senapssås, pepparrot, rostad potatis, bakad lök, persilja"));
            itemRepository.save(new Item("Fiskgryta",145,"sej, musslor, potatis, fänkål, dill, citron, aioli​"));
            itemRepository.save(new Item("Tomatsoppa",115,"Ägg 63, chili, krutonger, basilika​"));
            itemRepository.save(new Item("Viltpannbiffar",115,"löksås, syrad gurka, potatispure"));
            itemRepository.save(new Item("Grillad lammytter",115,"Basmatiris, Rogan Josh, paprika, chili, koriander, tomatsallad"));
        }; 

    }
    
    
    
    public List<Item> getAllItems()
    {
        
        List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(item -> items.add(item));
        
        return items; 
    }
    
    public Item getItemsByTitle(String title)
    {
        return itemRepository.findById(title).get();
    }
    
    public void saveOrUpdateItem(Item item)
    {
        itemRepository.save(item);
    }
    
    public void delete(String title)
    {
        itemRepository.deleteById(title);
    }
    
}
