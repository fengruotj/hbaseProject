package com.hbase.basic;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created by xgxyi01 on 16/5/14.
 */
public class HBaseUtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void Test() throws IOException {
        List<Result> resutList=HBaseUtils.getAllRecordByQualifier("DK00_NATIONEXP","info",new String[]{"NF"});
        TreeSet<String> set= new TreeSet<>();
        for(Result result :resutList){
            for(Cell cell:result.rawCells())
                 set.add(new String(CellUtil.cloneValue(cell)));
        }
        for(Object str :set.toArray())
        System.out.println((String)str);
        System.out.println("--------------------------------------");
    }

    @Test
    public void creatTable() throws Exception {

    }

    @Test
    public void deleteTable() throws Exception {

    }

    @Test
    public void addCoulumFamily() throws Exception {

    }

    @Test
    public void deleteCoulumFamily() throws Exception {

    }

    @Test
    public void addRecord() throws Exception {

    }

    @Test
    public void delRecord() throws Exception {

    }

    @Test
    public void getOneRecord() throws Exception {

    }

    @Test
    public void getAllRecord() throws Exception {

    }

    @Test
    public void getRecordByRowKey() throws Exception {

    }

    @Test
    public void getAllRecordByQualifier() throws Exception {

    }

    @Test
    public void getColumnResultbyFilter() throws Exception {
        List<Result> resultList= HBaseUtils.getColumnResultbyFilter("DK02_SUBCOMPEX","info", "YFGSMC" , CompareFilter.CompareOp.EQUAL," 中国石化湖北石油分公司1",new String[]{"KTJFTR","YFGSMC"});
        System.out.println(resultList.size());
    }

    @Test
    public void getColumnResultbyRegxFilter() throws Exception {

    }

    @Test
    public void getColumnResultbyBinaryComparatorFilter() throws Exception {

    }

    @Test
    public void getColumnResultbyBinaryPrefixComparatorFilter() throws Exception {
        HBaseUtils.getColumnResultbyBinaryPrefixComparatorFilter("DK01_COMPEXP","info","NF", CompareFilter.CompareOp.EQUAL,
                "2007",null);
    }

    @Test
    public void getPageResultByFilter() throws Exception {

    }

    @Test
    public void getColumnResultByComparable() throws Exception {

    }
}
