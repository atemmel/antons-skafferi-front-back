/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.ItemCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Integer> {

    @Query(value = "Select * from itemcategory where name like %?1%", nativeQuery = true)
    List<ItemCategory> itemCategoryFindByName(String name);
}
