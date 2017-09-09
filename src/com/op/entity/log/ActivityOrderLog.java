package com.op.entity.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单日志表(orderLog)实体类
 * 
 * @author 世峰户外商城
 * @version Revision: 1.00 Date: 2016-01-07 17:36:37
 */
public class ActivityOrderLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	private int aol_id;
	// 处理时间
	private Date aol_create_time;
	// 处理信息
	private String aol_info;
	// 操作人ID
	private String aol_create_user_id;
	// 操作人姓名
	private String aol_create_user_name;
	// 订单ID
	private String aol_order_id;

	/**
	 * id
	 */
	public int getAol_id() {
		return aol_id;
	}

	public void setAol_id(int aol_id) {
		this.aol_id = aol_id;
	}

	/**
	 * 处理时间
	 */
	public Date getAol_create_time() {
		return aol_create_time;
	}

	public void setAol_create_time(Date aol_create_time) {
		this.aol_create_time = aol_create_time;
	}

	/**
	 * 处理信息
	 */
	public String getAol_info() {
		return aol_info;
	}

	public void setAol_info(String aol_info) {
		this.aol_info = aol_info;
	}

	/**
	 * 操作人ID
	 */
	public String getAol_create_user_id() {
		return aol_create_user_id;
	}

	public void setAol_create_user_id(String aol_create_user_id) {
		this.aol_create_user_id = aol_create_user_id;
	}

	/**
	 * 操作人姓名
	 */
	public String getAol_create_user_name() {
		return aol_create_user_name;
	}

	public void setAol_create_user_name(String aol_create_user_name) {
		this.aol_create_user_name = aol_create_user_name;
	}

	public String getAol_order_id() {
		return aol_order_id;
	}

	public void setAol_order_id(String aol_order_id) {
		this.aol_order_id = aol_order_id;
	}

}
