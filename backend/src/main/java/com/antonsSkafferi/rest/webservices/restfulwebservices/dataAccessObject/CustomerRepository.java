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
import org.springframework.data.repository.query.Param;

/**
 *
 * @author FREDDE
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
    @Query(value = "Select * from customer where bookingdate like %?1% ORDER BY bookingtime", nativeQuery = true)
    List<Customer> customersDateTime(String date);
    
    @Query(value = "Select * from customer where firstname like %?1%", nativeQuery = true)
    List<Customer> customersFindByfirstName(String firstName);
    
    
    @Query(value = "Select * from customer where lastname like %?1%", nativeQuery = true)
    List<Customer> customersFindBylastName(String lastName);
    
    @Query(value = "Select * from customer where email like %?1%", nativeQuery = true)
    List<Customer> customersFindByEmail(String email);
    
    @Query(value = "Select * from customer where dinnertableid like %?1%", nativeQuery = true)
    List<Customer> customersFindByTable(int id);
    
    @Query(value = "SELECT * FROM CUSTOMER WHERE bookingdatetime LIKE %:bookingdatetime% AND FIRSTNAME LIKE %:firstname% AND LASTNAME LIKE %:secondname%", nativeQuery = true)
    Customer changeCustomerTable(
            @Param("bookingdatetime") String bookingdatetime,
            @Param("firstname") String firstname, 
            @Param("secondname") String secondname);
}
