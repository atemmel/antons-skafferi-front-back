/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT * FROM CUSTOMER WHERE NAME LIKE %?1%", nativeQuery = true)
    List<Customer> findByName(String name);
    
    @Query(value = "Select * from customer where bookingdatetime like %?1%", nativeQuery = true)
    List<Customer> customersToday(String date);
    
    @Query(value = "Select * from customer where name like %?1%", nativeQuery = true)
    List<Customer> customersName(String name);

}