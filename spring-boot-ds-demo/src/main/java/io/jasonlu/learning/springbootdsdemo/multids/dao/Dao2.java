package io.jasonlu.learning.springbootdsdemo.multids.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by jiehenglu on 17/07/25.
 */
@Repository
public class Dao2 {

//    @Autowired
//    @Qualifier("template2")
    @Resource(name = "template2")  // 和上面两句的效果一样
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
