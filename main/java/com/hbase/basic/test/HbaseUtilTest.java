package com.hbase.basic.test;

import com.hbase.basic.HBaseUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 5/12/16.
 */

public class HbaseUtilTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

        BeanFactory factory = (BeanFactory) context;
        HBaseUtil hBaseUtil = (HBaseUtil) factory.getBean("HBaseUtil");
        System.out.println(hBaseUtil.get("DK00_NATIONEXP","1"));
        System.out.println(hBaseUtil.get("DK00_NATIONEXP","1","info","KTTZ"));
        System.out.println(hBaseUtil.find("DK00_NATIONEXP","1","4"));
        System.out.println(hBaseUtil.execute("student","2","info","name","lisi"));
    }
}
