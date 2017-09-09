package com.op.entity.consignee_citys;

import java.io.Serializable;

/** 
 * 地区(市)实体类
 * @author 潘永威
 * @version Revision: 1.00 
 *  Date: 2015年12月18日 09:10:30
 */ 
public class Consignee_Citys implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String code;
	private String name;
	private String parent_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

}
