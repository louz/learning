package io.jasonlu.learning.springbootdsdemo.multids.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by jiehenglu on 17/07/25.
 */
@Repository
public class Dao1 {

    @Autowired
    @Qualifier("template1")
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
