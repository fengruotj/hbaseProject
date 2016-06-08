package com.hbase.basic.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * YqOilField entity. @author MyEclipse Persistence Tools
 */

public class YqOilField implements java.io.Serializable {

	// Fields

	private Integer id;
	private YqProvince yqProvince;
	private YqCompany yqCompany;
	private String name;
	private String yqtbm;
	private String longitude;
	private String latitude;
	private Integer status;
	private Set yqOilStatuses = new HashSet(0);

	// Constructors

	/** default constructor */
	public YqOilField() {
	}

	/** minimal constructor */
	public YqOilField(YqProvince yqProvince, YqCompany yqCompany, String name,
			String yqtbm, String longitude, String latitude, Integer status) {
		this.yqProvince = yqProvince;
		this.yqCompany = yqCompany;
		this.name = name;
		this.yqtbm = yqtbm;
		this.longitude = longitude;
		this.latitude = latitude;
		this.status = status;
	}

	/** full constructor */
	public YqOilField(YqProvince yqProvince, YqCompany yqCompany, String name,
			String yqtbm, String longitude, String latitude, Integer status,
			Set yqOilStatuses) {
		this.yqProvince = yqProvince;
		this.yqCompany = yqCompany;
		this.name = name;
		this.yqtbm = yqtbm;
		this.longitude = longitude;
		this.latitude = latitude;
		this.status = status;
		this.yqOilStatuses = yqOilStatuses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public YqProvince getYqProvince() {
		return this.yqProvince;
	}

	public void setYqProvince(YqProvince yqProvince) {
		this.yqProvince = yqProvince;
	}

	public YqCompany getYqCompany() {
		return this.yqCompany;
	}

	public void setYqCompany(YqCompany yqCompany) {
		this.yqCompany = yqCompany;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYqtbm() {
		return this.yqtbm;
	}

	public void setYqtbm(String yqtbm) {
		this.yqtbm = yqtbm;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getYqOilStatuses() {
		return this.yqOilStatuses;
	}

	public void setYqOilStatuses(Set yqOilStatuses) {
		this.yqOilStatuses = yqOilStatuses;
	}

}
