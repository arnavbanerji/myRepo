package com.Arnav.helpline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@ComponentScan
public class Application {

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }*/

    public static void main(String[] args) {
        // Reading Command-Line arguments
        for(String arg:args) {
            System.out.println(arg);
        }
        SpringApplication.run(Application.class, args);
    }

    //add the HTTP Endpoint to read the User Principal
    // from the Google after authenticating via Spring Boot
    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        return principal;
    }

    /*@Bean
    public ApplicatonStartupRunner scheduleRunner() {
        return new ApplicatonStartupRunner();
    }*/

}
