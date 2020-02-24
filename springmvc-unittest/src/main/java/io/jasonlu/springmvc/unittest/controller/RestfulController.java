package io.jasonlu.springmvc.unittest.controller;

import io.jasonlu.springmvc.unittest.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RestfulController {

    /**
     * 接受一个User对象
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/type3", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return user;
    }
}
