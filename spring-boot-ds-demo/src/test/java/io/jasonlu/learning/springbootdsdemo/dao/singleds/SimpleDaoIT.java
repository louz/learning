package io.jasonlu.learning.springbootdsdemo.dao.singleds;

import io.jasonlu.learning.springbootdsdemo.singleds.SingleDsConfig;
import io.jasonlu.learning.springbootdsdemo.singleds.dao.SimpleDao;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jiehenglu on 17/07/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleDsConfig.class)
public class SimpleDaoIT {

    @Autowired
    private SimpleDao dao;

    @Test
    public void testDao() {
        assertNotNull(dao);
    }

    @Test
    public void testGet() {
        assertThat(dao.get(1), Is.is("user1"));
    }
}
