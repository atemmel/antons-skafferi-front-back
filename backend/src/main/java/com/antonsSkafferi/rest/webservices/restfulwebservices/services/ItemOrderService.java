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
}
