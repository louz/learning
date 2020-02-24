package io.jasonlu.springrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
@Component
@ComponentScan
public class Demo {
//    private final RestTemplate restTemplate;

//    public Demo(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplate = restTemplateBuilder.build();
//    }

    public String getPostsPlainJSON() {

        RestTemplate restT = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Expect", "100-continue");
        // set `accept` header
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a map for post parameters
        Map<String, Object> map = new HashMap<>();
        map.put("body", "long text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text");

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // send POST request
        ResponseEntity<String> result = restT.postForEntity("http://localhost:8080/expect-demo", entity, String.class);
        return result.getBody();
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restT = new RestTemplate();
//        restT.setInterceptors(Collections.singletonList(new LoggingRestTemplate()));
//        return restT;
//    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Demo.class, args);

        Demo mainObj = ctx.getBean(Demo.class);

        String result = mainObj.getPostsPlainJSON();

        System.out.println(result);
    }
}
