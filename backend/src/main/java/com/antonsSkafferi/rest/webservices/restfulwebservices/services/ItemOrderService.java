/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.ItemOrderRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.ItemOrder;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public final class ItemOrderService {
    
    @Autowired
    ItemOrderRepository itemOrderRepository;
    
    private static ItemOrderService ItemOrderService;
    
    private ItemOrderService(){};
    
    
    public static ItemOrderService getInstance(){
        return ItemOrderService;
    }
    
    //GET FUNCTIONS 
    public List<ItemOrder> getAllOrders()
    {
        List<ItemOrder> orders = new ArrayList<>();
        itemOrderRepository.findAll().forEach(order -> orders.add(order));
        return orders;
    }
    
    public List<ItemOrder> getOrederByTable(int dinnertableid)
    {
        List<ItemOrder> orders = new ArrayList<>();
        itemOrderRepository.getOrderByTable(dinnertableid).forEach(order -> orders.add(order));
        return orders;
    }
    
    public void saveOrUpdateItemOrder(ItemOrder itemOrder)
    {
        itemOrderRepository.save(itemOrder);
    }
    
    public List<ItemOrder> getUnreadyOrders(){
        
        List<ItemOrder> orders = new ArrayList<>();
        itemOrderRepository.unreadyOrders().forEach(order -> orders.add(order));
        return orders;
    }
    
    public void setOrderReady(int dinnertableid){
        itemOrderRepository.setOrderReady(dinnertableid);
    }
    
    public List<ItemOrder> getReadyOrders(){
        List<ItemOrder> orders = new ArrayList<>();
        itemOrderRepository.readyOrders().forEach(order -> orders.add(order));
        return orders;
    }
    
    public void setOrderDeliverd(int dinnertableid){
       itemOrderRepository.setOrderDeliverd(dinnertableid);
    }
    
    public int getSumOfOrder(int dinnertable)
    {
        return itemOrderRepository.orderSum(dinnertable);
    }
}
