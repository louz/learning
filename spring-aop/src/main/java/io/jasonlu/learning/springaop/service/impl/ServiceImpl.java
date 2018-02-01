package io.jasonlu.learning.springaop.service.impl;


import io.jasonlu.learning.springaop.service.MyService;
import org.springframework.stereotype.Service;

/**
 * Created by jiehenglu on 17/08/02.
 */
@Service
public class ServiceImpl implements MyService {

    @Override
    public String hello() {
        System.out.println("=== say hello to world ===");
        return null;
    }

    @Override
    public void say(int i) {
        System.out.println(String.format("=== say %d ===", i));
    }
}
