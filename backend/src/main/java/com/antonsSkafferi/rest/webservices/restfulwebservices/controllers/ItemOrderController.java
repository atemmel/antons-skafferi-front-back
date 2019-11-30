/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.ItemOrderService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.ItemOrder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 */
@RestController
public class ItemOrderController {
    
    @Autowired
    ItemOrderService service = ItemOrderService.getInstance();
    
    
    //Get Requests
    @RequestMapping(value = "/orders")
    //Request GET
    private List<ItemOrder> getAllOrders(){
       return service.getAllOrders();
    }
}
