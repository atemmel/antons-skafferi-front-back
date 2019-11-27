/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import com.antonsSkafferi.rest.webservices.restfulwebservices.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    @GetMapping("/customers")
    //Request GET
    private List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    
    @GetMapping("/customers/{id}")
    //Request GET
    private Customer getCustomer(@PathVariable("id") int id){
        return customerService.getCustomerById(id);
    }
    
    @GetMapping("/customers/name/{name}")
    private List getCustomer(@PathVariable("name") String name){
        return customerService.customersByName(name);
    }
    
    @DeleteMapping("/customers/{id}")
    //Request DELETE
    private void deleteCustomer(@PathVariable("id") int id){

        customerService.delete(id);
    }
    @DeleteMapping("/customers")
    //Request DELETE
    private void deleteAll(){
        customerService.deleteAll();
    }
    
    
    /*Request POST
    {
	"bookingDateTime":"2017-07-16 22:54",
        "name":"Example",
        "email": "Example@example.com"
        "dinnertable": 1
    }
    */
    @PostMapping("/customers")
    private int saveCustomer(@RequestBody Customer customer){
        customerService.saveOrUpdateCustomer(customer);
        
        return customer.getCustomerid();
    }

    @GetMapping("/customers/today")
    private List customersForToday(){
         return customerService.customersForToday();
    }
    
}

    
