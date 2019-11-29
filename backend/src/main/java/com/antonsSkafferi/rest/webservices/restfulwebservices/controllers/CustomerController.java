/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Allamo Olsson
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
    
    @RequestMapping(value = "/customers/dinnertable", params="dinnerTable")
    private List getCustomerByTable(@RequestParam int dinnerTable){
        return service.customersByTable(dinnerTable);
    }
    
    
    @PostMapping(value = "/post/customers", params="customer")
    private void saveCustomer(@RequestBody Customer customer){
        service.saveOrUpdateCustomer(customer);
    }
    
    
    @PostMapping(value = "/post/customers/table", params={"date", "firstname", "secondname"})
    private void changeCustomerTable(@RequestParam String date, String firstname, String secondname){
        System.out.println("DET FUNKAR");
        service.changeCustomerTable(date, firstname, secondname);
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
    
    
    
    
}

    
