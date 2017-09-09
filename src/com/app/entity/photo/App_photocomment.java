package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 评论照片(app_photocomment)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-10-17 16:13:58 
 */  
public class App_photocomment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int pc_id;
 	//描述ID
  	 private int pd_id;
 	//评论人
  	 private int pc_cuser;
 	//评论时间
  	 private Date pc_cdate;
 	//评论内容
  	 private String pc_content;
 	//评论状态
  	 private int pc_status;
 	//删除（0：正常；1：删除）
  	 private int pc_delete;



	 
    /**
    *id
	* @return
    */ 
	public int getPc_id() {
		return pc_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}
    /**
    *描述ID
	* @return
    */ 
	public int getPd_id() {
		return pd_id;
	}
    /**
    *描述ID
	* @param type
    */ 
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
    /**
    *评论人
	* @return
    */ 
	public int getPc_cuser() {
		return pc_cuser;
	}
    /**
    *评论人
	* @param type
    */ 
	public void setPc_cuser(int pc_cuser) {
		this.pc_cuser = pc_cuser;
	}
    /**
    *评论时间
	* @return
    */ 
	public Date getPc_cdate() {
		return pc_cdate;
	}
    /**
    *评论时间
	* @param type
    */ 
	public void setPc_cdate(Date pc_cdate) {
		this.pc_cdate = pc_cdate;
	}
    /**
    *评论内容
	* @return
    */ 
	public String getPc_content() {
		return pc_content;
	}
    /**
    *评论内容
	* @param type
    */ 
	public void setPc_content(String pc_content) {
		this.pc_content = pc_content;
	}
    /**
    *评论状态
	* @return
    */ 
	public int getPc_status() {
		return pc_status;
	}
    /**
    *评论状态
	* @param type
    */ 
	public void setPc_status(int pc_status) {
		this.pc_status = pc_status;
	}
    /**
    *删除（0：正常；1：删除）
	* @return
    */ 
	public int getPc_delete() {
		return pc_delete;
	}
    /**
    *删除（0：正常；1：删除）
	* @param type
    */ 
	public void setPc_delete(int pc_delete) {
		this.pc_delete = pc_delete;
	}
	
}
