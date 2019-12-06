/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.ItemOrder;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface ItemOrderRepository extends JpaRepository<ItemOrder,Integer> {
    
    @Query(value = "Select * from ITEMORDER where ready = false", nativeQuery = true)
    List<ItemOrder> unreadyOrders();
   
    @Transactional
    @Modifying
    @Query(value= "UPDATE itemorder SET ready = true WHERE dinnertableid = ?1", nativeQuery = true)
    void setOrderReady(int dinnertableid);
}
