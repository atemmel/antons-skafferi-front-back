/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.CustomerRepository;
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
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class CustomerController {
    
    @Autowired
    CustomerService service = CustomerService.getInstance();
    
    
    //Get Requests
    @RequestMapping(value = "/customers")
    //Request GET
    private List<Customer> getAllCustomers(){
       return service.getAllCustomers();
    }
    
    @RequestMapping(value = "/customers/customer", params= "id")
    private Customer getCustomer(@RequestParam int id){
        return service.getCustomerById(id);
    }
    
    @RequestMapping(value = "/customers/customer", params= "firstName")
    private List getCustomerByFirstName(@RequestParam String firstName){
        return service.customersByfirstName(firstName);
    }
    
    @RequestMapping(value = "/customers/customer", params= "lastName")
    private List getCustomerByLastName(@RequestParam String lastName){
        return service.customersBylastName(lastName);
    }
    
    @RequestMapping(value = "/customers/customer", params = "email")
    private List getCustomerByEmail(@RequestParam String email){
        return service.customersByEmail(email);
    }
    
    @RequestMapping(value = "/customers/customer/today")
    private List getCustomerToday(){
        return service.customersToday();
    }
    
    @RequestMapping(value = "/customers/customer/date", params="dateTime")
    private List getCustomerDateTime(@RequestParam String dateTime){
        return service.customersByTime(dateTime);
    }
    
    
    
    
    
    
    //ALL DELETE REQUESTS
    @DeleteMapping("/customers/delete/customer")
    //Request DELETE
    private void deleteCustomer(@RequestParam int id){

        service.delete(id);
    }
    
    
    @DeleteMapping("/customers/delete/all")
    //Request DELETE
    private void deleteAll(){
        service.deleteAll();
    }
    
    
    /*Request POST
    {
	"bookingDateTime":"2017-07-16 22:54",
        "name":"Example",
        "email": "Example@example.com"
        "dinnertable": 1
    }
   
    @PostMapping("/customers")
    private int saveCustomer(@RequestBody Customer customer){
        customerService.saveOrUpdateCustomer(customer);
        
        return customer.getCustomerid();
    }

     */
}

    
