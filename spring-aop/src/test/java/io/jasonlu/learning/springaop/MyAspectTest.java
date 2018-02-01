package io.jasonlu.learning.springaop;

import io.jasonlu.learning.springaop.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jiehenglu on 17/08/02.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Config.class})
public class MyAspectTest {

    @Autowired
    private MyService service;

    @Test
    public void testHello() {
        service.hello();
    }

    @Test
    public void testSay() {
        service.say(1);
    }
}
