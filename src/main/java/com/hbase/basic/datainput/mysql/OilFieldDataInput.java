package com.hbase.basic.datainput.mysql;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by dello on 2016/6/8.
 */
public class OilFieldDataInput {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void login(){
        System.out.println(jdbcTemplate.queryForList("SELECT * FROM user WHERE username=? AND password=?","admin","123"));
    }
}
