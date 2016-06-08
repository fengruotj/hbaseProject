package com.hbase.basic.dao;

import com.hbase.basic.entity.YqOilField;
import com.hbase.basic.entity.YqOilStatus;
import com.hbase.basic.entity.YqProvince;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 	* A data access object (DAO) providing persistence and search support for YqArea entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control.
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class ServiceDAO extends BaseHibernateDAOImpl<Object>  {
	private static final Logger log = LoggerFactory.getLogger(ServiceDAO.class);

	public int getProvinceOilFieldCountByYear(int year, int province_id){
		List<YqOilStatus> yosList = this.findList("from YqOilStatus where status=1 and year="+year);
		int count = 0;
		for (YqOilStatus s : yosList){
			List<YqOilField> yofList = this.findList("from YqOilField where status=1 " +
					"and id="+s.getYqOilField().getId()+" and province_id="+province_id);
			if(yofList.size()>0){
				count++;
			}
		}
		return count;
	}

	public int getAreaOilFieldCountByYear(int year, int area_id){
		List<YqOilStatus> yosList = this.findList("from YqOilStatus where status=1 and year="+year);
		int count = 0;
		for (YqOilStatus s : yosList){
			List<YqProvince> provinceList = this.findList("from YqProvince where status=1 and area_id="+area_id);
			for (YqProvince province : provinceList){
				List<YqOilField> yofList = this.findList("from YqOilField where status=1 " +
						"and id="+s.getYqOilField().getId()+" and province_id="+province.getId());
				if(yofList.size()>0){
					count++;
				}
			}
		}
		return count;
	}

}
