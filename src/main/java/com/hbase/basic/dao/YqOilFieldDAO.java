package com.hbase.basic.dao;

import com.hbase.basic.entity.YqOilField;
import com.hbase.basic.entity.YqProvince;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 	* A data access object (DAO) providing persistence and search support for YqOilField entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control.
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class YqOilFieldDAO extends BaseHibernateDAOImpl<YqOilField>  {
	private static final Logger log = LoggerFactory.getLogger(YqOilFieldDAO.class);
	@Autowired
	private YqProvinceDAO yqProvinceDAO;

	public List<YqOilField> getOilFieldBaseInfoList(){
		return this.findList("FROM YqOilField WHERE status=1");
	}

	public YqOilField getOilFieldByYQTBM(String yqtbm){
		return this.get("FROM YqOilField WHERE status=1 and yqtbm=" + yqtbm);
	}

	public List<YqOilField> getOilFieldByProvinceId(int province_id){
		return this.findList("FROM YqOilField WHERE status=1 and province_id=" + province_id + " order by company_id");
	}

	public  List<YqOilField> getOilFieldByAreaIdandCompanyId(int areaId, int companyId){
		List<YqProvince> provinceList = yqProvinceDAO.getProvinceListByAreaId(areaId);
		List pids = new ArrayList();
		for (YqProvince province : provinceList){
			pids.add(province.getId());
		}
		Query query = getSession().createQuery("FROM YqOilField WHERE status=1 and company_id = :company_id and province_id in (:idList)");
		query.setParameter("company_id", companyId);
		query.setParameterList("idList", pids);
		return query.list();
	}

}
