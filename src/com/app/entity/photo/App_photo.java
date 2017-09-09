package com.app.entity.photo;

import java.io.Serializable;
/** 
 * 照片表(app_photo)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-10-17 16:13:58 
 */  
public class App_photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//ID
  	 private int p_id;
 	//描述ID
  	 private int pd_Id;
 	//图片路径
  	 private String p_url;
 	//删除(0：正常；1：回收站；2：删除)
  	 private int p_delete;



	 
    /**
    *ID
	* @return
    */ 
	public int getP_id() {
		return p_id;
	}
    /**
    *ID
	* @param type
    */ 
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
    /**
    *描述ID
	* @return
    */ 
	public int getPd_Id() {
		return pd_Id;
	}
    /**
    *描述ID
	* @param type
    */ 
	public void setPd_Id(int pd_Id) {
		this.pd_Id = pd_Id;
	}
    /**
    *图片路径
	* @return
    */ 
	public String getP_url() {
		return p_url;
	}
    /**
    *图片路径
	* @param type
    */ 
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
    /**
    *删除(0：正常；1：回收站；2：删除)
	* @return
    */ 
	public int getP_delete() {
		return p_delete;
	}
    /**
    *删除(0：正常；1：回收站；2：删除)
	* @param type
    */ 
	public void setP_delete(int p_delete) {
		this.p_delete = p_delete;
	}
	
}
