package com.hbase.basic.controller;

import com.hbase.basic.utils.HBaseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by dello on 2016/6/8.
 */
@Controller
public class HbaseController extends BaseController{
    /**
     *  为Hbse表添加Coprocessor类 用来统计表的个数
     * @param tableName
     * @throws IOException
     */
    @RequestMapping(value = "/addCoprocessorToTable",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addCoprocessorToTable(@RequestParam String tableName) throws IOException {
        HBaseUtils.addCoprocessorToTable(tableName);
        return "addCoprocessorToTable success!!!";
    }
}
