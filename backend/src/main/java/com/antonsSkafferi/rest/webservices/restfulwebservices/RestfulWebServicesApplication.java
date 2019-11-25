package com.antonsSkafferi.rest.webservices.restfulwebservices;

import com.antonsSkafferi.rest.webservices.restfulwebservices.dataAccessObject.DinnerTableRepository;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.Dinnertable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestfulWebServicesApplication {
    
    

    

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);      
    }
    @Bean
    public CommandLineRunner initDinnerTables(DinnerTableRepository dinnertablerepository) {
        return (args) -> {
            
            dinnertablerepository.save(new Dinnertable(1,"Fonsterbord",4));
            dinnertablerepository.save(new Dinnertable(2,"Fonsterbord",4));
            dinnertablerepository.save(new Dinnertable(3,"Fonsterbord",4));
            dinnertablerepository.save(new Dinnertable(4,"Langbord",12));
            dinnertablerepository.save(new Dinnertable(5,"Langbord",12));
            dinnertablerepository.save(new Dinnertable(6,"Langbord",12));
        }; 

    }
}
