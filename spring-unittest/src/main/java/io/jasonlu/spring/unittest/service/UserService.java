package io.jasonlu.spring.unittest.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUser() {
        return "Tom";
    }
}
