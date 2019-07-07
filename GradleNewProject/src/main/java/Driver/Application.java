package Driver;

import com.Arnav.LinearRegression.LinearRegressionDriver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(LinearRegressionDriver.class,args);
    }

    /*@Bean
    //you can use commandLineRunner to run custom code before springBoot app starts running
    //it gets called just before run(), also applicationRunner u can use
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            for(String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }*/
}
