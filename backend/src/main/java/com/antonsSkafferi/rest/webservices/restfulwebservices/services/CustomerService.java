/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.CustomerRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredriksellgren
 */
@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers()
    {
        List<Customer> customers;
        customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }
    
    public Customer getCustomerById(int id){
        
        return customerRepository.findById(id).get();
    }
    
    public void saveOrUpdateCustomer(Customer customer){
        
        customerRepository.save(customer);
    }
    
    
    public void delete(int id){
        customerRepository.deleteById(id);
    }
    
    public void deleteAll(){
    
        customerRepository.deleteAll();
    }
    
    //This is for listing the customers that visiting the resturang today, and make the resault to a JSON object. 
    public List customersForToday()
    {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDateTime.now();
        String dateForToday = dtf.format(date);
        //For testing
        dateForToday = "2019-01-21 20:30";
        
        List<Customer> customers = new ArrayList<>();
        customerRepository.customersToday(dateForToday).forEach(customer -> customers.add(customer));
        return customers;

    }
    
    public List customersByName(String name)
    {
    
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.customersName(name).forEach(customer -> customers.add(customer));
        return customers;
    
    }
}
    
