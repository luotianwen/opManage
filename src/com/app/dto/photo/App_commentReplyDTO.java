package com.app.dto.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 照片评论(app_commentReply)实体类
 * @author sen 
 * @version Revision: 1.00 
 *  Date: 2016-10-19 21:47:45 
 */  
public class App_commentReplyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int cr_id;
 	//描述ID
  	 private int pd_id;
 	//回复人
  	 private String cr_cuser;
 	//被回复人
  	 private String cr_byreply;
 	//评论时间
  	 private Date cr_cdate;
 	//评论内容
  	 private String cr_content;
 	//评论状态
  	 private int cr_status;
  	 //父ID
  	 private int cr_parent;
 	//删除（0：正常；1：删除）
  	 private int cr_delete;

  	//回复人昵称
 	private String rName;
 	//回复人头像
 	private String rHeadImg;
 	//被回复人昵称
 	private String brName;
 	//被回复人头像
 	private String brHeadImg;

	 
    /**
    *id
	* @return
    */ 
	public int getCr_id() {
		return cr_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setCr_id(int cr_id) {
		this.cr_id = cr_id;
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
    *回复人
	* @return
    */ 
	public String getCr_cuser() {
		return cr_cuser;
	}
    /**
    *回复人
	* @param type
    */ 
	public void setCr_cuser(String cr_cuser) {
		this.cr_cuser = cr_cuser;
	}
    /**
    *被回复人
	* @return
    */ 
	public String getCr_byreply() {
		return cr_byreply;
	}
    /**
    *被回复人
	* @param type
    */ 
	public void setCr_byreply(String cr_byreply) {
		this.cr_byreply = cr_byreply;
	}
    /**
    *评论时间
	* @return
    */ 
	public Date getCr_cdate() {
		return cr_cdate;
	}
    /**
    *评论时间
	* @param type
    */ 
	public void setCr_cdate(Date cr_cdate) {
		this.cr_cdate = cr_cdate;
	}
    /**
    *评论内容
	* @return
    */ 
	public String getCr_content() {
		return cr_content;
	}
    /**
    *评论内容
	* @param type
    */ 
	public void setCr_content(String cr_content) {
		this.cr_content = cr_content;
	}
    /**
    *评论状态
	* @return
    */ 
	public int getCr_status() {
		return cr_status;
	}
    /**
    *评论状态
	* @param type
    */ 
	public void setCr_status(int cr_status) {
		this.cr_status = cr_status;
	}
    /**
    *删除（0：正常；1：删除）
	* @return
    */ 
	public int getCr_delete() {
		return cr_delete;
	}
    /**
    *删除（0：正常；1：删除）
	* @param type
    */ 
	public void setCr_delete(int cr_delete) {
		this.cr_delete = cr_delete;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrHeadImg() {
		return rHeadImg;
	}
	public void setrHeadImg(String rHeadImg) {
		this.rHeadImg = rHeadImg;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrHeadImg() {
		return brHeadImg;
	}
	public void setBrHeadImg(String brHeadImg) {
		this.brHeadImg = brHeadImg;
	}
	public int getCr_parent() {
		return cr_parent;
	}
	public void setCr_parent(int cr_parent) {
		this.cr_parent = cr_parent;
	}
	
}
