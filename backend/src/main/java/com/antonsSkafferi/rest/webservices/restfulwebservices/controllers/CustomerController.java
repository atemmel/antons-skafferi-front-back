/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import com.antonsSkafferi.rest.webservices.restfulwebservices.services.CustomerService;
import java.sql.SQLException;
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
    private List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerService.getAllCustomers();
    }
    
    @GetMapping("/customers/{id}")
    //Request GET
    private Customer getCustomer(@PathVariable("id") int id){
        return customerService.getCustomerById(id);
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
	"bookingDateTime":"2017-07-16T22:54:01.000Z",
        "name":"Example",
        "email": "Example@example.com"
    }
    */
    @PostMapping("/customers")
    private int saveCustomer(@RequestBody Customer customer){
        customerService.saveOrUpdate(customer);
        return customer.getId();
    }
        @PostMapping("/customers/update")
    private int updateCustomer(@RequestBody Customer customer) throws SQLException, ClassNotFoundException{
        
        customerService.updateTable(5, "NAME", customer.getName().toString());
        return customer.getId();
    }
    
}

    
