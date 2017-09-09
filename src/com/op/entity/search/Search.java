package com.op.entity.search;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 项目名：outdoorPortal 类描述： 创建人：Win Zhong 创建时间： 2015-11-30
 * 最后修改时间：2015-12-21下午6:41:31
 */
public class Search {

	// 搜索类型{active:"活动",line:"线路"}
	private String type;
	// 搜索关键字
	private String keyword;
	// 位置中文名称
	private String position;
	// 经纬度
	private String bl;
	// 地图东北角坐标（用作查询半径用）
	private String northEast;
	// 距离范围 单位公里 （半径）
	private double d;
	// 适合人群ID
	private int sc;
	// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date st;
	// 结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lt;
	// 未来多久单位：天数
	private int days;
	// 周几
	private String week;
	// 活动是否收费（1：是；2：否）
	private int isCharge;
	// 活动收费价格
	private double price;

	/*------------------------------------	2015年12月21日   新增-------------------------------*/
	// 适合人群
	private int sc_id;
	// 适合儿童年龄段
	private int a_children_age;
	// 活动周期(天)
	private int a_date_length;
	// 活动难度等级
	private String a_difficulty_type;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*------------------------------------	get && set-------------------------------------*/

	public int getSc_id() {
		return sc_id;
	}

	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}

	public int getA_children_age() {
		return a_children_age;
	}

	public void setA_children_age(int a_children_age) {
		this.a_children_age = a_children_age;
	}

	public int getA_date_length() {
		return a_date_length;
	}

	public void setA_date_length(int a_date_length) {
		this.a_date_length = a_date_length;
	}

	public String getA_difficulty_type() {
		return a_difficulty_type;
	}

	public void setA_difficulty_type(String a_difficulty_type) {
		this.a_difficulty_type = a_difficulty_type;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		if (keyword == null) {
			return "";
		} else {
			return keyword;
		}
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getBl() {
		return bl;
	}

	public void setBl(String bl) {
		this.bl = bl;
	}

	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}

	public Date getSt() {
		return st;
	}

	public void setSt(Date st) {
		this.st = st;
	}

	public Date getLt() {
		return lt;
	}

	public void setLt(Date lt) {
		this.lt = lt;
	}

	public int getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(int isCharge) {
		this.isCharge = isCharge;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public String getPosition() {
		if (position == null) {
			return "";
		} else {
			return position;
		}
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNorthEast() {
		return northEast;
	}

	public void setNorthEast(String northEast) {
		this.northEast = northEast;
	}

	/**
	 * 未来多久
	 */
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

}
