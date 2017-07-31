package io.jasonlu.learning.springbootdsdemo.multids;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by jiehenglu on 17/07/21.
 */
@SpringBootApplication
public class MultiDsConfig {

    @Bean(name = "dataSource111")
    @Primary  // 使用方法声明的同类型Bean，必须有一个声明为Primary
    @ConfigurationProperties(prefix = "spring1.datasource")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSource222")
    @ConfigurationProperties(prefix = "spring2.datasource")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    // 注入Primary的DataSource
    @Bean(name = "template1")
    public JdbcTemplate jdbcTemplate1(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // 注入指定名称的DataSource，此处的@Qualifier必须，而且不能在方法上使用@Resource(name = "dataSource222")
    @Bean(name = "template2")
    public JdbcTemplate jdbcTemplate2(@Qualifier("dataSource222") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
