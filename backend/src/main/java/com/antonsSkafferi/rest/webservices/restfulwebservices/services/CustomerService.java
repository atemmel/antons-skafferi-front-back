/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.CustomerRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers; 
    }
    
    public Customer getCustomerById(int id){
        
        return customerRepository.findById(id).get();
    }
    
    public void saveOrUpdate(Customer customer){
    
        customerRepository.save(customer);
    }
    
    
    public void delete(int id){
        
        customerRepository.deleteById(id);
    }
    
    public void deleteAll(){
    
        customerRepository.deleteAll();
    }
    
    public void updateTable(int id, String colName,String newData) throws SQLException, ClassNotFoundException{
        Class.forName("org.h2.Driver");
        newData = "'"+newData+"'";
        //create connection for a server installed in localhost, with a user "root" with no password
        try (Connection conn = DriverManager.getConnection("jdbc:h2:file:./src/main/resources/database/database", "sa", "")) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                stmt.executeUpdate("UPDATE CUSTOMER SET "+colName+"="+newData+" WHERE ID ="+id);
                
            }
        }
    }
}
