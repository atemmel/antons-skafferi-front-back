/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fredriksellgren
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
}
