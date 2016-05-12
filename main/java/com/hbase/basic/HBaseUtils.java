package com.hbase.basic;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangchujie on 16/3/22.
 */

public class HBaseUtils {
    private static final Logger log = LoggerFactory.getLogger(HBaseUtils.class);
    private static Configuration conf = null;
    private static Connection connection;
    protected static Admin admin;
    static {
        try {
            org.apache.commons.configuration.Configuration config = new PropertiesConfiguration("hbase.properties");
            String hbase_zookeeper_client_port = config.getString("hbase.zk.port");
            String hbase_zookeeper_quorum = config.getString("hbase.zk.host");
            String hbase_master = config.getString("hbase.master");
            log.info("HBase config info zookeeper client port: "+hbase_zookeeper_client_port);
            log.info("HBase config info zookeeper quorum: "+hbase_zookeeper_quorum);
            log.info("HBase config info hbase master: "+hbase_master);
            conf = HBaseConfiguration.create();
            conf.set("hbase.zookeeper.property.clientPort", hbase_zookeeper_client_port);
            conf.set("hbase.zookeeper.quorum", hbase_zookeeper_quorum);
            conf.set("hbase.master", hbase_master);
            connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (ConfigurationException e) {
            e.printStackTrace();
            log.error("init HBase Configuration Exception: "+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("init HBase Configuration Exception: " + e.getMessage());
        }
    }

    /**
     * 创建 HBase 表
     * @param tableName
     * @param familys
     * @throws IOException
     */
    public static void creatTable(String tableName,String[] familys) throws IOException {
        if(admin.tableExists(TableName.valueOf(tableName))) {
            log.info("table already exists");
        } else {
            HTableDescriptor hTableDescriptor=new HTableDescriptor(TableName.valueOf(tableName));
            for (String family : familys) {
                hTableDescriptor.addFamily(new HColumnDescriptor(family));
            }
            admin.createTable(hTableDescriptor);
            log.info("create table:" + tableName + "  success");
        }
    }

    /**
     * 删除 Hbase 表
     * @param tableName
     * @throws IOException
     */
    public static void deleteTable(String tableName) throws IOException {
        TableName table_name = TableName.valueOf(tableName);
        admin.disableTable(table_name);
        admin.deleteTable(table_name);
        log.info("delete table:" + tableName + "  success");
    }

    /**
     * Hbase 插入数据
     * @param tableName
     * @param rowKey
     * @param family
     * @param qualifier
     * @param value
     * @throws IOException
     */
    public static void addRecord (String tableName, String rowKey, String family,
                                  String qualifier, String value) throws IOException {
        HTable table = (HTable) connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(Bytes.toBytes(rowKey));
        put.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes.toBytes(value));
        table.put(put);
        log.info("insert recored " + rowKey + " to table " + tableName + " success.");
    }

    /**
     * Hbase 删除数据
     * @param tableName
     * @param rowKey
     * @throws IOException
     */
    public static void delRecord (String tableName, String rowKey) throws IOException {
        HTable table = (HTable) connection.getTable(TableName.valueOf(tableName));
        Delete del = new Delete(rowKey.getBytes());
        table.delete(del);
        log.info("del recored " + rowKey + " success.");
    }

    /**
     * 根据 RowKey 查找数据
     * @param tableName
     * @param rowKey
     * @throws IOException
     */
    public static void getOneRecord (String tableName, String rowKey) throws IOException {
        HTable table = (HTable) connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(rowKey.getBytes());
        Result rs = table.get(get);
        for(Cell cell : rs.rawCells()){
            System.out.println("列簇为：" + new String(CellUtil.cloneFamily(cell)));
            System.out.println("值为："+new String(CellUtil.cloneValue(cell)));
        }
    }

    /**
     * 查询表中所有数据
     * @param tableName
     * @throws IOException
     */
    public static List<Result> getAllRecord (String tableName) throws IOException {
        List resultList = new ArrayList();
        HTable table = (HTable) connection.getTable(TableName.valueOf(tableName));
        Scan s = new Scan();
        ResultScanner ss = table.getScanner(s);
        for(Result r : ss){
            log.info("该表RowKey为：" + new String(r.getRow()));
            for(Cell cell : r.rawCells()){
                log.info("列簇为：" + new String(CellUtil.cloneFamily(cell)));
                log.info("列修饰符为："+new String(CellUtil.cloneQualifier(cell)));
                log.info("值为：" + new String(CellUtil.cloneValue(cell)));
            }
            resultList.add(r);
        }
        return resultList;
    }

    /**
     * 根据rwokey查询
     * @param tableName
     * @param rowKey
     * @return
     * @throws IOException
     */
    public static Result getRecordByRowKey(String tableName, String rowKey)
            throws IOException {
        HTable table = (HTable) connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = table.get(get);
        for(Cell cell : result.rawCells()){
            log.info("列簇为：" + new String(CellUtil.cloneFamily(cell)));
            log.info("列修饰符为："+new String(CellUtil.cloneQualifier(cell)));
            log.info("值为：" + new String(CellUtil.cloneValue(cell)));
        }
        return result;
    }

    /**
     * 获取某一列的所有数据
     * @param tableName
     * @param familyName
     * @param qualifierName
     * @return
     * @throws IOException
     */
    public static List<Result> getAllRecordByQualifier(String tableName, String familyName, List<String> qualifierNameList)
            throws IOException {
        List resultList = new ArrayList();
        HTable table = (HTable) connection.getTable(TableName.valueOf(tableName));
        Scan s = new Scan();
        for(String qualifier : qualifierNameList){
            s.addColumn(familyName.getBytes(), qualifier.getBytes());
        }
        ResultScanner ss = table.getScanner(s);
        for (Result r : ss){
            log.info("该表RowKey为：" + new String(r.getRow()));
            for(Cell cell : r.rawCells()){
                log.info("列簇为：" + new String(CellUtil.cloneFamily(cell)));
                log.info("列修饰符为：" + new String(CellUtil.cloneQualifier(cell)));
                log.info("值为：" + new String(CellUtil.cloneValue(cell)));
            }
            resultList.add(r);
        }
        return resultList;
    }

}
