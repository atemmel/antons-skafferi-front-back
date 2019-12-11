/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.services;

import java.util.ArrayList;

/**
 *
 * @author ninhow
 */
public class RequestService {
    public class Request {
        public int employeeId1;
        public int employeeId2;

        public int scheduleId1;
        public int scheduleId2;

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Request other = (Request) obj;
            if (this.employeeId1 != other.employeeId1) {
                return false;
            }
            if (this.employeeId2 != other.employeeId2) {
                return false;
            }
            if (this.scheduleId1 != other.scheduleId1) {
                return false;
            }
            if (this.scheduleId2 != other.scheduleId2) {
                return false;
            }
            return true;
        }
        
    }
    
    ArrayList<Request> requests = new ArrayList<>();
    
    private static RequestService requestService;
    
    private RequestService(){};
    
    public static RequestService getInstance(){
        return requestService;
    }
    
    public void addRequest(Request request) {
        int index = requests.indexOf(request);
        if(index != -1) {   //Om requesten redan existerar
            //Sätt in i databas
            requests.remove(index);
        } else {    //Annars läggs den till
            requests.add(request);
        }
    }
    
    public void clearRequests() {
        requests.clear();
    }
}
