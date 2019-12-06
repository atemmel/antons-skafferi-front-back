/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.UserService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.User;
import java.util.List;
import static jdk.internal.util.StaticProperty.userName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
    
    @Autowired
    UserService service = UserService.getInstance();
    
    
        
    @RequestMapping(value = "/users")
    //Request GET
    private List<User> getAllUsers(){
       return service.getAllUsers();
    }
    
    
    @RequestMapping(value = "/users/login", params= {"username", "password"})
    private User getUserLogin(@RequestParam String username, String password){
        return service.usersLogin(username, password);
    }
    
    @PostMapping(value = "/post/users", params="user")
    private void saveCustomer(@RequestBody User user){
        service.saveOrUpdateUser(user);
    }
    
    
}
