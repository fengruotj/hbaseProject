package com.hbase.basic.dao;

import com.hbase.basic.entity.YqOilStatus;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class YqOilStatusDAO extends BaseHibernateDAOImpl<YqOilStatus>  {
	private static final Logger log = LoggerFactory.getLogger(YqOilStatusDAO.class);

	public List<Integer> getYearsList(){
		return this.findList("SELECT DISTINCT(year) FROM YqOilStatus WHERE status=1 ORDER BY year");
	}

	public List<YqOilStatus> getOilFieldStatusList(int id){
		return this.findList("FROM YqOilStatus s WHERE status=1 and s.yqOilField.id="+ id +" ORDER BY year");
	}

	public double getOilFieldStatusByIdAndYear(int id, int year){
		String hql = "SELECT dnclzl FROM YqOilStatus s WHERE status=1 and s.yqOilField.id="+id+" and year="+year;
		Query query = this.getSession().createQuery(hql);
		List<Double> list = query.list();
		if(list.size()==0){
			return 0;
		} else {
			return list.get(0);
		}
	}

	public long getOilFieldSMZQ(int oilFieldId){
		String hql = "SELECT COUNT(*) FROM YqOilStatus WHERE status=1 AND oil_field_id="+oilFieldId;
		Query query =  this.getSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}

	public long getOilStatusCount(String name){
		Query query=getSession().createQuery("select count(s) from YqOilStatus s where s.yqOilField.name LIKE :name")
                .setString("name","%"+name+"%");
        return (long) query.uniqueResult();
	}

}
