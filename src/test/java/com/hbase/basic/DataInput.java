package com.hbase.basic;

import com.hbase.basic.utils.HBaseUtils;
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

    /**
     * 添加DK03_WELLINFO 钻井基本信息
     * @throws Exception
     */
    @Test
    public void addDK03_WELLINFO() throws Exception {
        Random random=new Random();
        HBaseUtils.creatTable("OILWELLINFO",new String[]{"info"});
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","JH","A1");
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","JHDM","db6546");
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","ZJBH","BC56");
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","JKZBX","233.5");       //井口坐标X
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","JKZBY","96.8");         //井口坐标Y
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","JDZBX","233.6");         //井底坐标X
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","JDZBY","233.7");         //井底坐标Y
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","YFGSBSM","yfgs123");     //油分公司标识码
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","YGSBSM","bm212");         //油公司标识码
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","SQBSM","BC56");         //省区标识码
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","KZRQ","1995-12-06");    //开钻日期
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","WZRQ","2012-10-07");    //完钻日期
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","BFRQ","2013-12-06");    //报废日期
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","WZRQ","2013-6-10");     //完钻日期
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","PDBSM","pdbsm123");     //盆地标识码
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","NF","2013");         //年份
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","BXHB","56");         //补心海拔
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","SJJS","78");         //设计井深
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","WZJS","23");         //完钻井深
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","SPDCD","22");         //水平段长度
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","WJFS","完井方式1");         //完井方式
        HBaseUtils.addRecord("OILFIELDINFO","A1","info","QKMC","区块名称1");         //区块名称1
    }

    /**
     *  添加油气公司信息表
     * @throws Exception
     */
    @Test
    public void addJ01_COMPINFO() throws Exception {
        HBaseUtils.creatTable("OILCOMPINFO",new String[]{"info"});
    }


    /**
     *  添加油气分公司信息表
     * @throws Exception
     */
    @Test
    public void addJ02_SUBCOMPINFO() throws Exception {
        HBaseUtils.creatTable("OILSUBCOMPINFO",new String[]{"info"});
    }

    /**
     *  添加省份信息表
     * @throws Exception
     */
    @Test
    public void addA03_PROVINFO() throws Exception {
        HBaseUtils.creatTable("OILPROVINFO",new String[]{"info"});
    }

    /**
     * 添加油气开采年检信息
     * @throws Exception
     */
    @Test
    public void addEN07_MININGAS() throws Exception {
        HBaseUtils.creatTable("OILMININGAS",new String[]{"info"});
    }

    /**
     * 添加油气勘探登记信息
     * @throws Exception
     */
    @Test
    public void addEK06_EXPLORATREGIST() throws Exception {
        HBaseUtils.creatTable("OILEXPLORATREGIST",new String[]{"info"});
    }

    /**
     * 添加油气大区信息表
     */
    public void addA08_REGIONINFO() throws Exception {
        HBaseUtils.creatTable("OILEXPLORATREGIST",new String[]{"info"});
    }

    @Test
    public void deleteOILFIELDINFO() throws IOException {
        HBaseUtils.deleteTable("OILFIELDINFO");
    }
}
