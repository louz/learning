package io.jasonlu.learning.springbootsprofile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jiehenglu on 17/07/31.
 */
@Service
@Profile("profile2")
public class Service2 implements MyService {
    @Override
    public String hello() {
        return "Service2";
    }
}
