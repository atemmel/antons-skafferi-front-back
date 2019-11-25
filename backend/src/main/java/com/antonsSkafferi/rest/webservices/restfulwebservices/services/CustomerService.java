/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.controllers.ConnectionManager;
import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.CustomerRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dinnertable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public void updateTable(int id, String email ,String Name, int dinnertable, String bookingdatetime) throws SQLException, ClassNotFoundException{
        try{
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
        System.out.println();
        System.out.println(Name);
        //create connection for a server installed in localhost, with a user "root" with no password
        Connection conn = ConnectionManager.getConnection();
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                //INSERT INTO CUSTOMER (BOOKINGDATETIME, EMAIL, NAME, DINNERTABLEID) VALUES('2019-01-21 21:30','TEST@GMAIL.COM', 'FREDDE', 1);
                stmt.executeUpdate("INSERT INTO CUSTOMER " + "VALUES (2,'2019-01-21 21:30','TEST@GMAIL.COM', 'FREDDE', 2)");
              
            }
    }
    public List customersForToday()
    {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDateTime.now();
        String dateForToday = dtf.format(date);
        dateForToday = "'"+dateForToday;
        dateForToday ="'2019-01-21";

        
        Map json = new HashMap(); 
        List contentList = new ArrayList();
        
        //create connection for a server installed in localhost, with a user "root" with no password
        try (Connection conn = ConnectionManager.getConnection()){
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                try (ResultSet resultSet = stmt.executeQuery("SELECT*From Customer where BOOKINGDATETIME LIKE "+ dateForToday+"%'")) {
                    //get the result from the executed query
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
  

                    
                    while(resultSet.next()){
                        Map<String,Object> columnMap = new HashMap<String, Object>();
                    //System.out.println(resultSetMetaData.getColumnLabel(2));
                    //System.out.println(resultSet.getString(resultSetMetaData.getColumnName(2)));
                        
                        for(int columnIndex=1; columnIndex <= resultSetMetaData.getColumnCount(); columnIndex++){
                            if(resultSet.getString(resultSetMetaData.getColumnName(columnIndex)) != null)
                                columnMap.put(resultSetMetaData.getColumnLabel(columnIndex).toLowerCase(),resultSet.getString(resultSetMetaData.getColumnName(columnIndex)));    
                            else
                                columnMap.put(resultSetMetaData.getColumnLabel(columnIndex), "");
                        }
                            contentList.add(columnMap);
                    }
                } catch (SQLException e){
                        e.printStackTrace();
                }
                json.put("Customer", contentList);
                return (ArrayList<String>) contentList;
            } 
        } catch(SQLException e ){
                e.printStackTrace();
            }
        return null;
    }

    public void updateTable(String email, String name, Dinnertable dinnertable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateTable(String email, String name, Dinnertable dinnertable, Timestamp bookingdatetime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
