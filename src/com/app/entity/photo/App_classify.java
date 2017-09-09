package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 照片分类(app_photoclassify)实体类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */  
public class App_classify implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String c_id;
 	//分类内容
  	 private String c_name;
 	//状态(0：正常；1：暂停使用)
  	 private int c_status;



	 
    /**
    *id
	* @return
    */ 
	public String getC_id() {
		return c_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
    /**
    *分类内容
	* @return
    */ 
	public String getC_name() {
		return c_name;
	}
    /**
    *分类内容
	* @param type
    */ 
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
    /**
    *状态(0：正常；1：暂停使用)
	* @return
    */ 
	public int getC_status() {
		return c_status;
	}
    /**
    *状态(0：正常；1：暂停使用)
	* @param type
    */ 
	public void setC_status(int c_status) {
		this.c_status = c_status;
	}
	
}
