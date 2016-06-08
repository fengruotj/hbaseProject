package com.hbase.basic.controller;

import com.hbase.basic.entity.YqOilField;
import com.hbase.basic.entity.YqOilStatus;
import com.hbase.basic.page.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dello on 2016/6/8.
 */
@Controller
@Transactional
public class YqOilFieldController extends BaseController {

    /**
     *  得到油气田基本信息分页效果
     * @param oilField
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/queryOilFieldByPage",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryOilFieldByPage(YqOilField oilField, @RequestParam Integer page,
                                  @RequestParam Integer rows){
        Map param=new HashMap();
        param.put("name","%"+oilField.getName()+"%");
        Pagination<YqOilField> pagination= oilFieldDAO.findPagination("from YqOilField where name LIKE :name",param,page,rows);
        List list=new ArrayList();
        for(YqOilField temp:pagination.getItems()){
            Map map=new HashMap<>();
            map.put("id",temp.getId());
            map.put("name",temp.getName());
            map.put("yqtbm",temp.getYqtbm());
            map.put("longitude",temp.getLatitude());
            map.put("latitude",temp.getLatitude());
            map.put("yqProvince",temp.getYqCompany().getName());
            map.put("yqCompany",temp.getYqCompany().getName());
            map.put("status",temp.getStatus());
            list.add(map);
        }
        return gsonUtil.GsonString(list);
    }

    /**
     *  得到油气田详细信息分页效果
     * @param
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/queryOilStatusByPage",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryOilStatusByPage(@RequestParam String name, @RequestParam Integer page,
                                       @RequestParam Integer rows){
        Map param=new HashMap();
        param.put("name","%"+name+"%");
        Pagination<YqOilStatus> pagination= oilStatusDAO.findPagination("from YqOilStatus s where s.yqOilField.name LIKE :name",param,page,rows);
        List list=new ArrayList();
        for(YqOilStatus temp:pagination.getItems()){
            Map map=new HashMap<>();
            map.put("id",temp.getId());
            map.put("name",temp.getYqOilField().getName());
            map.put("cccd",temp.getCccd());
            map.put("ccb",temp.getCcb());
            map.put("zhhsl",temp.getZhhsl());
            map.put("dnclzl",temp.getDnclzl());
            map.put("ykftmdzclzl",temp.getYkftmdzclzl());
            map.put("wkftmdzclzl",temp.getWkftmdzclzl());
            map.put("wkftmjskcclzl",temp.getWkftmjskcclzl());
            map.put("ykftmjskcclzl",temp.getYkftmjskcclzl());
            map.put("ykftmjjkcclzl",temp.getYkftmjjkcclzl());
            map.put("wkftmjjkcclzl",temp.getWkftmjjkcclzl());
            map.put("year",temp.getYear());
            map.put("status",temp.getStatus());
            list.add(map);
        }
        return gsonUtil.GsonString(list);
    }
}
