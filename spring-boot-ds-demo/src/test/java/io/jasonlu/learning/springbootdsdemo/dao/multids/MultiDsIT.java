package io.jasonlu.learning.springbootdsdemo.dao.multids;

import io.jasonlu.learning.springbootdsdemo.multids.MultiDsConfig;
import io.jasonlu.learning.springbootdsdemo.multids.dao.Dao1;
import io.jasonlu.learning.springbootdsdemo.multids.dao.Dao2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by jiehenglu on 17/07/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiDsConfig.class)
public class MultiDsIT {

    @Autowired
    private Dao1 dao1;

    @Autowired
    private Dao2 dao2;

    @Resource(name = "dataSource111")
    private DataSource ds1;

    @Resource(name = "dataSource222")
    private DataSource ds2;

    @Test
    public void testInit() {
        assertNotNull(dao1);
        assertNotNull(dao1.getJdbcTemplate());
        assertSame(dao1.getJdbcTemplate().getDataSource(), ds1);

        assertNotNull(dao2);
        assertNotNull(dao2.getJdbcTemplate());
        assertSame(dao2.getJdbcTemplate().getDataSource(), ds2);
    }
}
