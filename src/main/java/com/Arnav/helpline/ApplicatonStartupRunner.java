/*
package com.Arnav.helpline;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;


public class ApplicatonStartupRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Arnav's Application Started !!");
        logger.info("getting the list of all beans that spring boot is offering !!");
        String[] beanNames = ctx.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
*/
