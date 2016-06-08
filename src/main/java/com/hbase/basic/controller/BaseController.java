package com.hbase.basic.controller;

import com.hbase.basic.dao.YqOilFieldDAO;
import com.hbase.basic.dao.YqOilStatusDAO;
import com.hbase.basic.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by dello on 2016/6/8.
 */
@Controller
public class BaseController {

    @Autowired
    protected GsonUtil gsonUtil;

    @Autowired
    protected YqOilFieldDAO oilFieldDAO;

    @Autowired
    protected YqOilStatusDAO oilStatusDAO;
}
