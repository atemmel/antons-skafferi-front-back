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
    
    @Query(value = "Select * from ITEMORDER where ready = 0", nativeQuery = true)
    List<ItemOrder> unreadyOrders();
   
    @Transactional
    @Modifying
    @Query(value= "UPDATE itemorder SET ready = 1 WHERE dinnertableid = ?1", nativeQuery = true)
    void setOrderReady(int dinnertableid);
    
    @Query(value= "Select * from ITEMORDER where ready = 1", nativeQuery = true)
    List<ItemOrder> readyOrders();
    
    @Transactional
    @Modifying
    @Query(value= "UPDATE itemorder SET ready = 2 WHERE dinnertableid = ?1", nativeQuery = true)
    void setOrderDeliverd(int dinnertableid);
    
    @Query(value = "SELECT SUM (price * amount) FROM ITEM INNER JOIN ITEMORDER ON ITEM.ITEMID = ITEMORDER.ITEMID AND DINNERTABLEID = ?1", nativeQuery = true)
    int orderSum(int dinnertableid);
    
    @Query(value = "SELECT * FROM itemorder WHERE dinnertableid = ?1", nativeQuery = true)
    List<ItemOrder> getOrderByTable(int dinnertableid);
    
    @Query(value = "Select * from ITEMORDER order by ready", nativeQuery = true)
    List<ItemOrder> sortedOrders();
    
    @Query(value = "SELECT * FROM ITEMORDER where not READY  = 2", nativeQuery = true)
    List<ItemOrder> getOrderToPrepare();
}
