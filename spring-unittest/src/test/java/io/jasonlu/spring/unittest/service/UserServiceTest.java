package io.jasonlu.spring.unittest.service;

import io.jasonlu.spring.unittest.Config;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Config.class})  // 使用java代码配置时的方式
// @ContextConfiguration(locations = {"classpath:spring.xml"}) 或 @ContextConfiguration("classpath:spring.xml")  使用xml配置文件时的使用方式
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void test1() {
        assertEquals("Tom", service.getUser());
    }
}
