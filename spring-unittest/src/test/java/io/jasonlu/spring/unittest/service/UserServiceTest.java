package io.jasonlu.spring.unittest.service;

import io.jasonlu.spring.unittest.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(Config.class)  // 使用java代码配置时的方式
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void test1() {
        assertEquals("Tom", service.getUser());
    }
}
