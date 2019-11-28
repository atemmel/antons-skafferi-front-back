/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dish;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface DishRepository extends JpaRepository<Dish,String> {
    
    @Query(value = "Select * from dish where type like %?1%", nativeQuery = true)
    List<Dish> dishFindByType(String type);
    
    @Query(value = "Select * from dish where title like %?1%", nativeQuery = true)
    List<Dish> dishFindByTitle(String title);
    
    @Query(value = "Select * from dish where description like %?1%", nativeQuery = true)
    List<Dish> dishFindByDescription(String description);
    
    @Query(value = "Select * from dish where price like %?1%", nativeQuery = true)
    List<Dish> dishFindByPrice(int price);
}

