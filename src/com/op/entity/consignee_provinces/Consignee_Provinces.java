package com.op.entity.consignee_provinces;

import java.io.Serializable;

/** 
 * 地区(省)实体类
 * @author PYW
 * @version Revision: 1.00 
 *  Date: 2015年12月18日 09:09:23
 */ 
public class Consignee_Provinces implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
}
