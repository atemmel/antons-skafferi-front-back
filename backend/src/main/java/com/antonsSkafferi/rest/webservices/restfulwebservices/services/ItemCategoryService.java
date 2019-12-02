/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.ItemCategory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.ItemCategoryRepository;

/**
 *
 * @author fredriksellgren
 */
@Service
public class ItemCategoryService {
    @Autowired
    ItemCategoryRepository itemCategoryRepository;
    
    private static ItemCategoryService ItemCategoryService;
    
    private ItemCategoryService(){};
    
    public static ItemCategoryService getInstance(){
        return ItemCategoryService;
    }
    
    @Bean
    public CommandLineRunner initItemCategory(ItemCategoryRepository itemCategoryRepository) {
        return (args) -> {
            
            itemCategoryRepository.save(new ItemCategory(1,"Kött","url"));
            itemCategoryRepository.save(new ItemCategory(2,"Förrätt","url"));
            itemCategoryRepository.save(new ItemCategory(3,"Efterrätt","url"));
            itemCategoryRepository.save(new ItemCategory(4,"Kockens Val","url"));
            itemCategoryRepository.save(new ItemCategory(5,"Vilt","url"));
            itemCategoryRepository.save(new ItemCategory(6,"À La Carte","url"));
            itemCategoryRepository.save(new ItemCategory(7,"Dryck","url"));
        }; 

    }
    
    public List<ItemCategory> getAllItems()
    {
        
        List<ItemCategory> items;
        items = new ArrayList<>();
        itemCategoryRepository.findAll().forEach(item -> items.add(item));
        
        return items; 
    }
    
    public List<ItemCategory> getItemCategoryByName(String name)
    {
        List<ItemCategory> itemCategorys = new ArrayList<>();
        itemCategoryRepository.itemCategoryFindByName(name).forEach(itemCategory -> itemCategorys.add(itemCategory));
        return itemCategorys;
    }
    
    public void saveOrUpdateItemCategory(ItemCategory itemCategory)
    {
        itemCategoryRepository.save(itemCategory);
    }
    
    public void delete(int id)
    {
        itemCategoryRepository.deleteById(id);
    }
    
    public void deleteAll()
    {
        itemCategoryRepository.deleteAll();
    }
}
