/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.UserRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredriksellgren
 */
@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    private static UserService UserService;
    
    public static UserService getInstance(){
        return UserService;
    }
    
    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }
    
    public User getUserById(int userid)
    {
        return userRepository.getUserById(userid);
    }
    
    public User usersLogin(String username, String password)
    {
        return userRepository.usersLogin(username, password);
    }
    
    public void saveOrUpdateUser(User user){   
        userRepository.save(user);
    }
}