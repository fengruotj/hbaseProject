package com.hbase.basic.dao;


import com.hbase.basic.entity.YqArea;
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
public class YqAreaDAO extends BaseHibernateDAOImpl<YqArea>  {
	private static final Logger log = LoggerFactory.getLogger(YqAreaDAO.class);

	public List<YqArea> getAreaList(){
		return this.findList("From YqArea WHERE status=1");
	}

	public YqArea getAreaInfoById(int id){
		return this.get("FROM YqArea where id="+id);
	}

}
