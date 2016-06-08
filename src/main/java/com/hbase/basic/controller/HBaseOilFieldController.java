package com.hbase.basic.controller;

import com.hbase.basic.utils.HBasePageUtils;
import com.hbase.basic.utils.HBaseUtils;
import com.hbase.basic.utils.TBData;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dello on 2016/6/8.
 */
@Controller
public class HBaseOilFieldController extends BaseController {

    private Logger logger= LoggerFactory.getLogger(HBaseOilFieldController.class);

    @RequestMapping(value = "/queryHbaseOilFieldByPage",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryHbaseOilFieldByPage(@RequestParam(value = "name") String name,@RequestParam Integer page,
                                           @RequestParam Integer rows) throws IOException {
        Scan scan=new Scan();
        SubstringComparator comparator=new SubstringComparator(name);
        SingleColumnValueFilter singleColumnValueFilter=new SingleColumnValueFilter("info".getBytes(),"YQTMC".getBytes(),
                CompareFilter.CompareOp.EQUAL,comparator
        );
        scan.setFilter(singleColumnValueFilter);

        TBData oilfieldinfo = HBasePageUtils.getDataMap("OILFIELDINFO", page, rows, scan);
        Map root=new HashMap<>();
        root.put("rows",oilfieldinfo.getResultList());
        root.put("total", HBaseUtils.getTableCount("OILFIELDINFO",scan));
        String jsonstring =gsonUtil.GsonString(root);
        logger.info("==============OILFIELDINFO :"+jsonstring);
        return jsonstring;
    }
}
