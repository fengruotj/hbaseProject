package com.hbase.basic.dao;

import com.hbase.basic.entity.YqCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class YqCompanyDAO extends BaseHibernateDAOImpl<YqCompany>  {
	private static final Logger log = LoggerFactory.getLogger(YqCompanyDAO.class);

	public List<YqCompany> getCompanyList(){
		return this.findList("FROM YqCompany WHERE status=1");
	}

	public YqCompany getCompanyById(int id){
		return this.get("FROM YqCompany WHERE status=1 and id="+id);
	}

}
