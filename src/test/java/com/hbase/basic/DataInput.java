package com.hbase.basic;

import org.junit.Test;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Wiwi on 2016/5/19.
 */
public class DataInput {

    @Test
    public void Test() throws IOException {
        HBaseUtils.creatTable("test",new String[]{"info"});
        HBaseUtils.addRecord("test","1","info","name","tanjie");
    }

    /**
     *   添加A06_OILFIELDINFO 石油基本信息
     * @throws IOException
     */
    @Test
    public void addA06_OILFIELDINFO() throws IOException {
        Random random=new Random();
        HBaseUtils.creatTable("A06_OILFIELDINFO",new String[]{"info"});
        for(int i=1;i<=9;i++)
            for(int j=1;j<=9;j++){
                HBaseUtils.addRecord("A06_OILFIELDINFO","A"+i,"info","YQTMC","油气田"+i);
                HBaseUtils.addRecord("A06_OILFIELDINFO","A"+i,"info","YQTBM","A"+i);
                HBaseUtils.addRecord("A06_OILFIELDINFO","A"+i,"info","PDMC","油气盆地"+i);
                HBaseUtils.addRecord("A06_OILFIELDINFO","A"+i,"info","SSPDBM","P"+i);
                HBaseUtils.addRecord("A06_OILFIELDINFO","A"+i,"info","NF",String.valueOf(2006+j));
                HBaseUtils.addRecord("A06_OILFIELDINFO","A"+i,"info","MJ",String.valueOf(random.nextDouble()*300)+200);
            }
    }

    @Test
    public void deleteA06_OILFIELDINFO() throws IOException {
        HBaseUtils.deleteTable("A06_OILFIELDINFO");
    }
}
