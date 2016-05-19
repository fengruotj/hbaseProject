package com.hbase.basic;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Wiwi on 2016/5/19.
 */
public class DataInput {

    @Test
    public void Test() throws IOException {
        HBaseUtils.creatTable("test",new String[]{"info"});
        HBaseUtils.addRecord("test","1","info","name","tanjie");
    }
}
