package io.jasonlu.learning.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Louz on 2016/8/15.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/redis.single.spring.xml"})
public class RedisGetSetTest {

    @Autowired
    private RedisTemplate<String, String> template;

    @Test
    public void testSetGet() {
        String value = "value2";

        template.opsForValue().set("key1", value);
        assertThat(template.opsForValue().get("key1"), is(value));
    }
}
