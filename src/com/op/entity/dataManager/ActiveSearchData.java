package com.op.entity.dataManager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 活动筛选条件表(activeSearchData)实体类
 * 
 * @author 世峰户外商城
 * @version Revision: 1.00 Date: 2015-12-21 19:10:06
 */
public class ActiveSearchData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	private String asd_id;
	// 条件标题/名称
	private String asd_name;
	// 条件值
	private String asd_value;
	// 条件父ID（0位顶级标题）
	private String asd_parent_id;
	// 条件类型（0：radio；1：checkbox）
	private int asd_type;
	// 条件排序
	private int asd_order_num;
	// 创建时间
	private Date asd_create_time;
	// 创建用户
	private String asd_create_user;
	// 修改时间
	private Date asd_update_time;
	// 修改用户
	private String asd_update_user;
	// 修改用户姓名
	private String asd_update_user_name;
	
	// 子数据集合
	private List<ActiveSearchData> childrenList;
	
	
	/**
	 * 子数据集合
	 */
	public List<ActiveSearchData> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List<ActiveSearchData> childrenList) {
		this.childrenList = childrenList;
	}

	/**
	 * 修改用户姓名
	 */
	public String getAsd_update_user_name() {
		return asd_update_user_name;
	}

	public void setAsd_update_user_name(String asd_update_user_name) {
		this.asd_update_user_name = asd_update_user_name;
	}

	/**
	 * id
	 */
	public String getAsd_id() {
		return asd_id;
	}

	public void setAsd_id(String asd_id) {
		this.asd_id = asd_id;
	}

	/**
	 * 条件标题/名称
	 */
	public String getAsd_name() {
		return asd_name;
	}

	public void setAsd_name(String asd_name) {
		this.asd_name = asd_name;
	}

	/**
	 * 条件值
	 */
	public String getAsd_value() {
		return asd_value;
	}

	public void setAsd_value(String asd_value) {
		this.asd_value = asd_value;
	}

	/**
	 * 条件父ID（0位顶级标题）
	 */
	public String getAsd_parent_id() {
		return asd_parent_id;
	}

	public void setAsd_parent_id(String asd_parent_id) {
		this.asd_parent_id = asd_parent_id;
	}

	/**
	 * 条件类型（0：radio；1：checkbox）
	 */
	public int getAsd_type() {
		return asd_type;
	}

	public void setAsd_type(int asd_type) {
		this.asd_type = asd_type;
	}

	/**
	 * 条件排序
	 */
	public int getAsd_order_num() {
		return asd_order_num;
	}

	public void setAsd_order_num(int asd_order_num) {
		this.asd_order_num = asd_order_num;
	}

	/**
	 * 创建时间
	 */
	public Date getAsd_create_time() {
		return asd_create_time;
	}

	public void setAsd_create_time(Date asd_create_time) {
		this.asd_create_time = asd_create_time;
	}

	/**
	 * 创建用户
	 */
	public String getAsd_create_user() {
		return asd_create_user;
	}

	public void setAsd_create_user(String asd_create_user) {
		this.asd_create_user = asd_create_user;
	}

	/**
	 * 修改时间
	 */
	public Date getAsd_update_time() {
		return asd_update_time;
	}

	public void setAsd_update_time(Date asd_update_time) {
		this.asd_update_time = asd_update_time;
	}

	/**
	 * 修改用户
	 */
	public String getAsd_update_user() {
		return asd_update_user;
	}

	public void setAsd_update_user(String asd_update_user) {
		this.asd_update_user = asd_update_user;
	}

}
