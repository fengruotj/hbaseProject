package com.hbase.basic.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * YqCompany entity. @author MyEclipse Persistence Tools
 */

public class YqCompany implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer status;
	private Set yqOilFields = new HashSet(0);

	// Constructors

	/** default constructor */
	public YqCompany() {
	}

	/** minimal constructor */
	public YqCompany(String name, Integer status) {
		this.name = name;
		this.status = status;
	}

	/** full constructor */
	public YqCompany(String name, Integer status, Set yqOilFields) {
		this.name = name;
		this.status = status;
		this.yqOilFields = yqOilFields;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getYqOilFields() {
		return this.yqOilFields;
	}

	public void setYqOilFields(Set yqOilFields) {
		this.yqOilFields = yqOilFields;
	}

}
