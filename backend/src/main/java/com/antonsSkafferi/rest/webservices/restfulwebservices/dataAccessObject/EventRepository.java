/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface EventRepository extends JpaRepository<Event,String> {
    
    @Query(value = "Select * from event where eventdate = ?1", nativeQuery = true)
    Event findEvent(String date);
}
