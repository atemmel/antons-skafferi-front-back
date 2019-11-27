/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fredriksellgren
 */

public class ConnectionManager {
    //the Path to database location
    private static String url = "jdbc:h2:file:../database";
    //What database driver your going to use
    private static String driverName = "org.h2.Driver";
    
    private static String username = "sa";   
    private static String password = "";
    private static Connection con;

    public static Connection getConnection() {
        try {
            //Trying to use the database driver
            Class.forName(driverName);
            try {
                //Trying to connect to database url whit username and password
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver for database not found."); 
        }
        //Return the connection to database
        return con;
    }
}
