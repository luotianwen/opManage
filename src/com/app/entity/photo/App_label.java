package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 照片标签(app_photolabel)实体类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */  
public class App_label implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String l_id;
 	//标签内容
  	 private String l_name;
 	//状态(0：正常；1：暂停使用)
  	 private int l_status;



	 
    /**
    *id
	* @return
    */ 
	public String getL_id() {
		return l_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setL_id(String l_id) {
		this.l_id = l_id;
	}
    /**
    *标签内容
	* @return
    */ 
	public String getL_name() {
		return l_name;
	}
    /**
    *标签内容
	* @param type
    */ 
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
    /**
    *状态(0：正常；1：暂停使用)
	* @return
    */ 
	public int getL_status() {
		return l_status;
	}
    /**
    *状态(0：正常；1：暂停使用)
	* @param type
    */ 
	public void setL_status(int l_status) {
		this.l_status = l_status;
	}
	
}
