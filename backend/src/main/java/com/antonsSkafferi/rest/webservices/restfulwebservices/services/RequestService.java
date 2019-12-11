/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import com.antonsSkafferi.rest.webservices.restfulwebservices.classes.Request;
import java.util.ArrayList;

/**
 *
 * @author ninhow
 */
public class RequestService {
       
    ArrayList<Request> requests = new ArrayList<>();
    
    private static RequestService requestService;
    
    private RequestService(){
        requestService = new RequestService();
    };
    
    
    public static RequestService getInstance(){
           return requestService; 
    }
    
    public void addRequest(Request request) {
        int index = requests.indexOf(request);
        if(index != -1) {   //Om requesten redan existerar
        } else {    
            //Annars läggs den till
            requests.add(request);
        }
    }
    
    
    public void clearRequests() {
        requests.clear();
    }
}
