package com.hbase.basic.controller;

import com.hbase.basic.utils.HBasePageUtils;
import com.hbase.basic.utils.TBData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by dello on 2016/6/8.
 */
@Controller
public class HBaseOilFieldController extends BaseController {

    private Logger logger= LoggerFactory.getLogger(HBaseOilFieldController.class);

    @RequestMapping(value = "/queryHbaseOilFieldByPage",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryHbaseOilFieldByPage(@RequestParam(value = "name",required = false) String name,@RequestParam Integer page,
                                           @RequestParam Integer rows) throws IOException {
        TBData oilfieldinfo = HBasePageUtils.getDataMap("OILFIELDINFO", "", "", page, rows, false);
        String jsonstring =gsonUtil.GsonString(oilfieldinfo.getResultList());
        logger.info("==============OILFIELDINFO :"+jsonstring);
        return jsonstring;
    }
}
