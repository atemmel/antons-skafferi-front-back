/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dinnertable;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface DinnerTableRepository extends JpaRepository<Dinnertable,Integer> {
    
    @Query(value = "SELECT * FROM DINNERTABLE D WHERE NOT EXISTS(SELECT 1 FROM CUSTOMER C WHERE D.DINNERTABLEID = C.DINNERTABLEID AND C.BOOKINGDATE = ?1) ", nativeQuery = true)
    List<Dinnertable> dinnerTableFindUnbookedTablesByDate(String date);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE DINNERTABLE SET active = 1 WHERE dinnertableid = ?1", nativeQuery = true)
    void setActiveTrue(int dinnertableid);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE DINNERTABLE SET active = 0 WHERE dinnertableid = ?1", nativeQuery = true)
    void setActiveFalse(int dinnertableid);
    
    @Query(value = "SELECT active FROM DINNERTABLE WHERE dinnertableid = ?1", nativeQuery = true)
    boolean checkActive(int dinnertableid);
}
