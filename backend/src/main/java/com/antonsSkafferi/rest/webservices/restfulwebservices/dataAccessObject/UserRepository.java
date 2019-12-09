/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject;

import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fredriksellgren
 */
public interface UserRepository extends JpaRepository<User,String> {
    
    
    @Query(value = "Select * from user where username = ?1 and password = ?2", nativeQuery = true)
    User usersLogin(String username, String password);
    
    @Query(value = "Select * from user where userid = ?1", nativeQuery = true)
    User getUserById(int userid);
}
