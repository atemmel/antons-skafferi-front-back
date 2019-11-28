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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredriksellgren
 */
@Service
public final class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;
    
    private static CustomerService CustomerService;
    
    private CustomerService(){};
    
    public static CustomerService getInstance(){
        return CustomerService;
    }
    
    
    //GET FUNCTIONS 
    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }
    
    public Customer getCustomerById(int id){
        
        return customerRepository.findById(id).get();
    }
    
    
    
    public List<Customer> customersByfirstName(String name)
    {
    
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.customersFindByfirstName(name).forEach(customer -> customers.add(customer));
        return customers;
    
    }
    
    public List<Customer> customersBylastName(String lastName)
    {
    
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.customersFindBylastName(lastName).forEach(customer -> customers.add(customer));
        return customers;
    
    }
    
    public List<Customer> customersByEmail(String email){
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.customersFindByEmail(email).forEach(customer -> customers.add(customer));
        return customers;
        
    }
    
    
    
    //TODO: FIX THIS SHIT
    public List customersToday()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDateTime.now();
        String dateForToday = dtf.format(date);
        System.out.println(dateForToday);
        List<Customer> customers = new ArrayList<>();
        customerRepository.customersDateTime(dateForToday).forEach(customer -> customers.add(customer));
        return customers;

    }
    
    public List<Customer> customersByTime(String time){
        List<Customer> customers = new ArrayList<>();
        customerRepository.customersDateTime(time).forEach(customer -> customers.add(customer));
        return customers;

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
    
}
    
