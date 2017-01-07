package io.jasonlu.springrestful.controller;

import io.jasonlu.springrestful.bean.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by louz on 2016/9/22.
 */
@RestController
@RequestMapping("/users")
public class RestfulController {

    /**
     * 方式1
     *
     * @param id
     * @return 返回一个ResponseEntity对象
     */
    @RequestMapping(value="/type1/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById1(@PathVariable int id) {
        return ResponseEntity.ok(new User(id, "type1 user"));
    }

    /**
     * 方式2
     *
     * @param id
     * @return 返回一个POJO
     */
    @RequestMapping(value="/type2/{id}", method = RequestMethod.GET)
    public User getUserById2(@PathVariable String id) {
        return new User(1, "type2 user");
    }
}
