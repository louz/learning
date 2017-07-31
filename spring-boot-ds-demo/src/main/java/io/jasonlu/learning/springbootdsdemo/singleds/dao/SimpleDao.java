package io.jasonlu.learning.springbootdsdemo.singleds.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by jiehenglu on 17/07/19.
 */
@Repository
public class SimpleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String get(int id) {
        return jdbcTemplate.queryForObject("select name from t1 where id = ?", new Object[]{id}, String.class);
    }
}
