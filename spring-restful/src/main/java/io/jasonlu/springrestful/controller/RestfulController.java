package io.jasonlu.springrestful.controller;

import io.jasonlu.springrestful.bean.ComplexMap;
import io.jasonlu.springrestful.bean.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 接受一个复杂嵌套的对象
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/type4", method = RequestMethod.POST)
    public ComplexMap saveMap(@RequestBody ComplexMap map) {
        return map;
    }
}
