package com.Arnav.LinearRegression;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LinearRegressionDriver extends implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    public static void main(String[] args) {
        System.out.println("I'm in linear regression class");
    }

}
