/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;


import com.antonsSkafferi.rest.webservices.restfulwebservices.services.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */
@RestController
public class DishCategoryController {
        @Autowired
    DishCategoryService dishCategoryService;
}
