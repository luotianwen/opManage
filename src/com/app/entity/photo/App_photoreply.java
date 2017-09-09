package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 照片评论回复表(app_photoreply)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-10-17 16:13:58 
 */  
public class App_photoreply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int pr_id;
  	 //描述ID
  	 private int pd_id;
 	//评论id
  	 private int pc_id;
 	//回复时间
  	 private Date pr_date;
 	//回复人
  	 private int pr_reply;
 	//被回复人
  	 private int pr_byreply;
 	//回复内容
  	 private String pr_content;
 	//删除（0：正常；1：删除）
  	 private int pr_delete;



	 
    /**
    *id
	* @return
    */ 
	public int getPr_id() {
		return pr_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}
    /**
    *评论id
	* @return
    */ 
	public int getPc_id() {
		return pc_id;
	}
    /**
    *评论id
	* @param type
    */ 
	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}
    /**
    *回复时间
	* @return
    */ 
	public Date getPr_date() {
		return pr_date;
	}
    /**
    *回复时间
	* @param type
    */ 
	public void setPr_date(Date pr_date) {
		this.pr_date = pr_date;
	}
    /**
    *回复人
	* @return
    */ 
	public int getPr_reply() {
		return pr_reply;
	}
    /**
    *回复人
	* @param type
    */ 
	public void setPr_reply(int pr_reply) {
		this.pr_reply = pr_reply;
	}
    /**
    *被回复人
	* @return
    */ 
	public int getPr_byreply() {
		return pr_byreply;
	}
    /**
    *被回复人
	* @param type
    */ 
	public void setPr_byreply(int pr_byreply) {
		this.pr_byreply = pr_byreply;
	}
    /**
    *回复内容
	* @return
    */ 
	public String getPr_content() {
		return pr_content;
	}
    /**
    *回复内容
	* @param type
    */ 
	public void setPr_content(String pr_content) {
		this.pr_content = pr_content;
	}
    /**
    *删除（0：正常；1：删除）
	* @return
    */ 
	public int getPr_delete() {
		return pr_delete;
	}
    /**
    *删除（0：正常；1：删除）
	* @param type
    */ 
	public void setPr_delete(int pr_delete) {
		this.pr_delete = pr_delete;
	}
	/**
	 * 描述ID
	 * @return
	 */
	public int getPd_id() {
		return pd_id;
	}
	/**
	 * 描述ID
	 * @return
	 */
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
	
}
