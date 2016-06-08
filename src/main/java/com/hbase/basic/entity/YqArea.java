package com.hbase.basic.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * YqArea entity. @author MyEclipse Persistence Tools
 */

public class YqArea implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer status;
	private Set yqProvinces = new HashSet(0);

	// Constructors

	/** default constructor */
	public YqArea() {
	}

	/** minimal constructor */
	public YqArea(String name, Integer status) {
		this.name = name;
		this.status = status;
	}

	/** full constructor */
	public YqArea(String name, Integer status, Set yqProvinces) {
		this.name = name;
		this.status = status;
		this.yqProvinces = yqProvinces;
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

	public Set getYqProvinces() {
		return this.yqProvinces;
	}

	public void setYqProvinces(Set yqProvinces) {
		this.yqProvinces = yqProvinces;
	}

}
