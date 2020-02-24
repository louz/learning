package io.jasonlu.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@SpringBootApplication
public class Example {

    @RequestMapping(value = "/demo", method = {RequestMethod.GET})
    public String sayHello(@RequestParam("key1") String value) {
        return String.format("Hello %s !", value);
    }

    @RequestMapping(value = "/expect-demo", method = {RequestMethod.POST})
    public String sayHello(@RequestBody Map<String, String> body) {
        return String.format("Hello %s !", body);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}