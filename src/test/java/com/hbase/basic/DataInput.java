package com.hbase.basic;

import org.junit.Test;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Wiwi on 2016/5/19.
 */
public class DataInput {
    private String oilFiedlGeoHYQCX="含油气层系1,含油气层系2,含油气层系3,含油气层系4,含油气层系5";
    private String getOilFiedlGeoYX="岩性1,岩性2,岩性3,岩性4,岩性5";

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
    public void addOILFIELDINFO() throws IOException {
        Random random=new Random();
        HBaseUtils.creatTable("OILFIELDINFO",new String[]{"info"});
        for(int i=1;i<=9;i++)
            for(int j=1;j<=9;j++){
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","YQTMC","油气田"+i);  //油气田名称
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","YQTBM","A"+i);        //油气田编码
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","PDMC","油气盆地"+i);
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","SSPDBM","P"+i);
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","YQCLX","油气藏类型"+i);       //油气藏类型
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","NF",String.valueOf(2006+j));  //年份
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","SQMC","省区"+i);               //省区名称
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","CJYHD",String.valueOf(random.nextDouble()*100)+20); //沉积岩厚度
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","TMCD",String.valueOf(random.nextDouble()*10)+2); //探明程度
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","MJ",String.valueOf(random.nextDouble()*300)+200);

                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","ZHHSL",String.valueOf(random.nextDouble()*300)+200);      //综合含水量
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","CCCD",String.valueOf(random.nextDouble()));      //采出程度
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","CCB",String.valueOf(random.nextDouble()));      //储采比
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","LJTMDZCLZL",String.valueOf(random.nextDouble()*200)+200);      //累计探明地质储量重量
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","LJTMDZCLTJ",String.valueOf(random.nextDouble()*200)+200);      //累计探明地质储量体积

                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","HYQCX",oilFiedlGeoHYQCX.split(",")[random.nextInt(5)]);        //含油气层系
                HBaseUtils.addRecord("OILFIELDINFO","A"+i,"info","YX",getOilFiedlGeoYX.split(",")[random.nextInt(5)]);        //岩系
            }
    }

    @Test
    public void deleteOILFIELDINFO() throws IOException {
        HBaseUtils.deleteTable("OILFIELDINFO");
    }
}
