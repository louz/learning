package io.jasonlu.springbootstandalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by jiehenglu on 17/02/14.
 */
@EnableAutoConfiguration
@Component
@ComponentScan
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);

        Main mainObj = ctx.getBean(Main.class);

        mainObj.init();
    }

    private void init() {
        System.out.println("Hello spring boot standalone application");
    }

}
