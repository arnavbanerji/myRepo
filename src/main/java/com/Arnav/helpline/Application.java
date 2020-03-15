package com.Arnav.helpline;

import com.Arnav.helpline.model.Helpline;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
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


    /*@Bean
    public ApplicatonStartupRunner scheduleRunner() {
        return new ApplicatonStartupRunner();
    }*/

}
