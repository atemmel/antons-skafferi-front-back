/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface ItemRepository extends JpaRepository<Item,String> {
    
    @Query(value = "Select * from item where type like %?1%", nativeQuery = true)
    List<Item> itemFindByType(String type);
    
    @Query(value = "Select * from item where title like %?1%", nativeQuery = true)
    List<Item> itemFindByTitle(String title);
    
    @Query(value = "Select * from item where description like %?1%", nativeQuery = true)
    List<Item> itemFindByDescription(String description);
    
    @Query(value = "Select * from item where price like %?1%", nativeQuery = true)
    List<Item> itemFindByPrice(int price);
}

