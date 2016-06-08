package com.hbase.basic.dao;

import com.hbase.basic.entity.YqProvince;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 	* A data access object (DAO) providing persistence and search support for YqProvince entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control.
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class YqProvinceDAO extends BaseHibernateDAOImpl<YqProvince>  {
	private static final Logger log = LoggerFactory.getLogger(YqProvinceDAO.class);

	public List<YqProvince> getProvinceList(){
		return this.findList("FROM YqProvince WHERE status=1");
	}

	public List<YqProvince> getProvinceListByAreaId(int areaId){
		return this.findList("FROM YqProvince WHERE status=1 and area_id="+areaId);
	}

}
