/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dinnertable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface DinnerTableRepository extends JpaRepository<Dinnertable,Integer> {
    
    @Query(value = "SELECT * FROM DINNERTABLE D WHERE NOT EXISTS(SELECT 1 FROM CUSTOMER C WHERE D.DINNERTABLEID = C.DINNERTABLEID AND C.BOOKINGDATE = ?1) ", nativeQuery = true)
    List<Dinnertable> dinnerTableFindUnbookedTablesByDate(String date);
}
