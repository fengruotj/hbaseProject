package com.hbase.basic.entity;

/**
 * YqOilStatus entity. @author MyEclipse Persistence Tools
 */

public class YqOilStatus implements java.io.Serializable {

	// Fields

	private Integer id;
	private YqOilField yqOilField;
	private Integer year;
	private double cccd;
	private double ccb;
	private double zhhsl;
	private double dnclzl;
	private double ykftmdzclzl;
	private double wkftmdzclzl;
	private double wkftmjskcclzl;
	private double ykftmjskcclzl;
	private double ykftmjjkcclzl;
	private double wkftmjjkcclzl;
	private Integer status;

	// Constructors

	/** default constructor */
	public YqOilStatus() {
	}

	/** full constructor */
	public YqOilStatus(YqOilField yqOilField, Integer year, double cccd,
			double ccb, double zhhsl, double dnclzl, double ykftmdzclzl,
			double wkftmdzclzl, double wkftmjskcclzl, double ykftmjskcclzl,
			double ykftmjjkcclzl, double wkftmjjkcclzl, Integer status) {
		this.yqOilField = yqOilField;
		this.year = year;
		this.cccd = cccd;
		this.ccb = ccb;
		this.zhhsl = zhhsl;
		this.dnclzl = dnclzl;
		this.ykftmdzclzl = ykftmdzclzl;
		this.wkftmdzclzl = wkftmdzclzl;
		this.wkftmjskcclzl = wkftmjskcclzl;
		this.ykftmjskcclzl = ykftmjskcclzl;
		this.ykftmjjkcclzl = ykftmjjkcclzl;
		this.wkftmjjkcclzl = wkftmjjkcclzl;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public YqOilField getYqOilField() {
		return this.yqOilField;
	}

	public void setYqOilField(YqOilField yqOilField) {
		this.yqOilField = yqOilField;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public double getCccd() {
		return this.cccd;
	}

	public void setCccd(double cccd) {
		this.cccd = cccd;
	}

	public double getCcb() {
		return this.ccb;
	}

	public void setCcb(double ccb) {
		this.ccb = ccb;
	}

	public double getZhhsl() {
		return this.zhhsl;
	}

	public void setZhhsl(double zhhsl) {
		this.zhhsl = zhhsl;
	}

	public double getDnclzl() {
		return this.dnclzl;
	}

	public void setDnclzl(double dnclzl) {
		this.dnclzl = dnclzl;
	}

	public double getYkftmdzclzl() {
		return this.ykftmdzclzl;
	}

	public void setYkftmdzclzl(double ykftmdzclzl) {
		this.ykftmdzclzl = ykftmdzclzl;
	}

	public double getWkftmdzclzl() {
		return this.wkftmdzclzl;
	}

	public void setWkftmdzclzl(double wkftmdzclzl) {
		this.wkftmdzclzl = wkftmdzclzl;
	}

	public double getWkftmjskcclzl() {
		return this.wkftmjskcclzl;
	}

	public void setWkftmjskcclzl(double wkftmjskcclzl) {
		this.wkftmjskcclzl = wkftmjskcclzl;
	}

	public double getYkftmjskcclzl() {
		return this.ykftmjskcclzl;
	}

	public void setYkftmjskcclzl(double ykftmjskcclzl) {
		this.ykftmjskcclzl = ykftmjskcclzl;
	}

	public double getYkftmjjkcclzl() {
		return this.ykftmjjkcclzl;
	}

	public void setYkftmjjkcclzl(double ykftmjjkcclzl) {
		this.ykftmjjkcclzl = ykftmjjkcclzl;
	}

	public double getWkftmjjkcclzl() {
		return this.wkftmjjkcclzl;
	}

	public void setWkftmjjkcclzl(double wkftmjjkcclzl) {
		this.wkftmjjkcclzl = wkftmjjkcclzl;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
