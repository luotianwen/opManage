package com.op.entity.lines;

import java.util.Date;
/** 
 * 活动总体线路(activeLines)实体类
 * @author 世峰户外商城 
 * @version Revision: 1.00 
 *  Date: 2015-12-10 10:51:36 
 */  
public class ActiveLines {


 	//总体线路ID
  	 private String al_id;
 	//总体线路地图标注(坐标集合)
  	 private String al_coordinates;
 	//总体线路描述
  	 private String al_description;
 	//总体线路创建时间
  	 private Date al_create_time;
 	//总体线路创建用户
  	 private String al_create_user;
 	//总体线路修改人
  	 private String al_update_user;
 	//总体线路修改时间
  	 private Date al_update_time;
 	//是否已经删除（0：默认值；1：是）
  	 private int al_is_delete;



	 
    /**
    *总体线路ID
    */ 
	public String getAl_id() {
		return al_id;
	}
	public void setAl_id(String al_id) {
		this.al_id = al_id;
	}
    /**
    *总体线路地图标注(坐标集合)
    */ 
	public String getAl_coordinates() {
		return al_coordinates;
	}
	public void setAl_coordinates(String al_coordinates) {
		this.al_coordinates = al_coordinates;
	}
    /**
    *总体线路描述
    */ 
	public String getAl_description() {
		return al_description;
	}
	public void setAl_description(String al_description) {
		this.al_description = al_description;
	}
    /**
    *总体线路创建时间
    */ 
	public Date getAl_create_time() {
		return al_create_time;
	}
	public void setAl_create_time(Date al_create_time) {
		this.al_create_time = al_create_time;
	}
    /**
    *总体线路创建用户
    */ 
	public String getAl_create_user() {
		return al_create_user;
	}
	public void setAl_create_user(String al_create_user) {
		this.al_create_user = al_create_user;
	}
    /**
    *总体线路修改人
    */ 
	public String getAl_update_user() {
		return al_update_user;
	}
	public void setAl_update_user(String al_update_user) {
		this.al_update_user = al_update_user;
	}
    /**
    *总体线路修改时间
    */ 
	public Date getAl_update_time() {
		return al_update_time;
	}
	public void setAl_update_time(Date al_update_time) {
		this.al_update_time = al_update_time;
	}
    /**
    *是否已经删除（0：默认值；1：是）
    */ 
	public int getAl_is_delete() {
		return al_is_delete;
	}
	public void setAl_is_delete(int al_is_delete) {
		this.al_is_delete = al_is_delete;
	}
	
}
