package com.hbase.basic;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 5/12/16.
 */

/**
 *
 */
@Component
public class HBaseTempUtil {

    @Autowired
    protected HbaseTemplate htemplate;

    public HbaseTemplate getHtemplate() {
        return htemplate;
    }

    public void setHtemplate(HbaseTemplate htemplate) {
        this.htemplate = htemplate;
    }

    /**
     *  写数据
     * @param tableName  表的名字
     * @param key        RowKey 主键
     * @param familyName coulumFamily列族
     * @param qualifier  column列的名字
     * @param value      值
     * @return
     */
    public Boolean execute(String tableName, final String key, final String familyName , final String qualifier, final String value) {
        return htemplate.execute(tableName, new TableCallback<Boolean>() {
            public Boolean doInTable(HTableInterface table) throws Throwable {
                boolean flag = false;
                try{
                    byte[] rowkey = key.getBytes();
                    Put put = new Put(rowkey);
                    put.add(Bytes.toBytes(familyName),Bytes.toBytes(qualifier), Bytes.toBytes(value));
                    table.put(put);
                    flag = true;
                }catch(Exception e){
                    e.printStackTrace();
                }
                return flag;
            }
        });
    }


    /**
     *   //删除一个表的 RowKey 下的所有列 指定列族
     * @param tableName 表的名字
     * @param key   //表的key
     * @param familyName 表的列族
     * @param filedList 表的字段列数组
     * @return
     */
    public boolean delete(String tableName, String key ,String familyName ,String[] filedList){
        try {
            for(String filed: filedList){
                htemplate.delete(tableName,key,familyName ,filed);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 通过表名和key获取一行数据
     * @param tableName
     * @param rowName
     * @return
     */
    public Map<String, Object> get(String tableName, String rowName) {
        return htemplate.get(tableName, rowName,new RowMapper<Map<String,Object>>(){
            public Map<String,Object> mapRow(Result result, int rowNum) throws Exception {
                List<Cell> ceList =   result.listCells();
                Map<String,Object> map = new HashMap<String, Object>();
                if(ceList!=null&&ceList.size()>0){
                    for(Cell cell:ceList){
                        map.put(Bytes.toString(cell.getFamilyArray(),cell.getFamilyOffset(),cell.getFamilyLength())+
                                        "_"+Bytes.toString( cell.getQualifierArray(),cell.getQualifierOffset(),cell.getQualifierLength()),
                                Bytes.toString( cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                    }
                }
                return  map;
            }
        });
    }

    /**
     * 通过表名  key 和 列族 和列 获取一个数据
     * @param tableName
     * @param rowName     RowKey 主键
     * @param familyName   coulumFamily列族
     * @param qualifier column列的名字
     * @return
     */
    public String get(String tableName ,String rowName, String familyName, String qualifier) {
        return htemplate.get(tableName, rowName,familyName,qualifier ,new RowMapper<String>(){
            public String mapRow(Result result, int rowNum) throws Exception {
                List<Cell> ceList =   result.listCells();
                String res = "";
                if(ceList!=null&&ceList.size()>0){
                    for(Cell cell:ceList){
                        res = Bytes.toString( cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                    }
                }
                return res;
            }
        });
    }


    /**
     * 通过表名，开始行键和结束行键获取数据
     * @param tableName 表的名字
     * @param startRow
     * @param stopRow
     * @return
     */
    public List<Map<String,Object>> find(String tableName , String startRow,String stopRow) {
        Scan scan = new Scan();
        if(startRow==null){
            startRow="";
        }
        if(stopRow==null){
            stopRow="";
        }
        scan.setStartRow(Bytes.toBytes(startRow));
        scan.setStopRow(Bytes.toBytes(stopRow));
		/* PageFilter filter = new PageFilter(5);
		 scan.setFilter(filter);*/
        return 	htemplate.find(tableName, scan,new RowMapper<Map<String,Object>>(){
            public Map<String,Object> mapRow(Result result, int rowNum) throws Exception {

                List<Cell> ceList =   result.listCells();
                Map<String,Object> map = new HashMap<String,Object>();
                Map<String,Map<String,Object>> returnMap = new HashMap<String,Map<String,Object>>();
                String  row = "";
                if(ceList!=null&&ceList.size()>0){
                    for(Cell cell:ceList){
                        row =Bytes.toString( cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
                        String value =Bytes.toString( cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                        String family =  Bytes.toString(cell.getFamilyArray(),cell.getFamilyOffset(),cell.getFamilyLength());
                        String quali = Bytes.toString( cell.getQualifierArray(),cell.getQualifierOffset(),cell.getQualifierLength());
                        map.put(family+"_"+quali, value);
                    }
                    map.put("row",row );
                }
                return  map;
            }
        });
    }


	/* public  void scanValueByFilter(String tableName,String row) throws IOException{
         HTable table = new HTable(conf, tableName);
         Scan scan = new Scan();
         scan.setFilter(new PrefixFilter(row.getBytes()));
         ResultScanner resultScanner = table.getScanner(scan);
         for(Result rs:resultScanner){


         }

     }*/
}
