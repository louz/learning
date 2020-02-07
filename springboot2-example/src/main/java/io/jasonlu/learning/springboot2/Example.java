package io.jasonlu.learning.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Example {

    @RequestMapping(value = "/demo", method = {RequestMethod.GET})
    public String sayHello(@RequestParam("key1") String value) {
        return String.format("Hello %s !", value);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}