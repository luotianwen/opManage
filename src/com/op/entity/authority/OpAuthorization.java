package com.op.entity.authority;

import java.io.Serializable;
/** 
 * 前台角色菜单对应表(opAuthorization)实体类
 * @author 世峰户外商城 
 * @version Revision: 1.00 
 *  Date: 2016-01-13 15:16:53 
 */  
public class OpAuthorization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String opa_id;
 	//角色ID
  	 private int opa_user_type;
 	//菜单ID
  	 private String opa_menu_id;



	 
    /**
    *id
    */ 
	public String getOpa_id() {
		return opa_id;
	}
	public void setOpa_id(String opa_id) {
		this.opa_id = opa_id;
	}
    /**
    *角色ID
    */ 
	public int getOpa_user_type() {
		return opa_user_type;
	}
	public void setOpa_user_type(int opa_user_type) {
		this.opa_user_type = opa_user_type;
	}
    /**
    *菜单ID
    */ 
	public String getOpa_menu_id() {
		return opa_menu_id;
	}
	public void setOpa_menu_id(String opa_menu_id) {
		this.opa_menu_id = opa_menu_id;
	}
	
}
