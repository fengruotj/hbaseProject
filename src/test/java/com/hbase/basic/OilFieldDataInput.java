package com.hbase.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dello on 2016/6/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
public class OilFieldDataInput {

    @Autowired
    @Qualifier("orcalejdbctemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void login(){
        System.out.println(jdbcTemplate.queryForList("SELECT * FROM user WHERE username=? AND password=?","admin","123"));
    }
}
