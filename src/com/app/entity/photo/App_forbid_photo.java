package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 用户禁言表(app_forbid_photo)实体类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-18 20:32:44 
 */  
public class App_forbid_photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int fp_id;
 	//用户ID
  	 private String fp_forbid_user;
 	//禁言原因
  	 private String fp_reason;
 	//禁言时长
  	 private String fp_forbid_time;
 	//解封时间
  	 private Date fp_dearchive;
 	//创建人
  	 private String fp_cuser;
 	//创建时间
  	 private Date fp_cdate;
 	//修改人
  	 private String fp_updateuser;
 	//修改时间
  	 private Date fp_updatetime;
 	//状态(0：禁言；1：解封)
  	 private int fp_status;
  	//描述ID
  	 private String pd_id;
 	//评论ID
  	 private String pc_id;
 	//回复ID
  	 private String pr_id;


	 
    /**
    *id
	* @return
    */ 
	public int getFp_id() {
		return fp_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setFp_id(int fp_id) {
		this.fp_id = fp_id;
	}
    /**
    *用户ID
	* @return
    */ 
	public String getFp_forbid_user() {
		return fp_forbid_user;
	}
    /**
    *用户ID
	* @param type
    */ 
	public void setFp_forbid_user(String fp_forbid_user) {
		this.fp_forbid_user = fp_forbid_user;
	}
    /**
    *禁言原因
	* @return
    */ 
	public String getFp_reason() {
		return fp_reason;
	}
    /**
    *禁言原因
	* @param type
    */ 
	public void setFp_reason(String fp_reason) {
		this.fp_reason = fp_reason;
	}
    /**
    *禁言时长
	* @return
    */ 
	public String getFp_forbid_time() {
		return fp_forbid_time;
	}
    /**
    *禁言时长
	* @param type
    */ 
	public void setFp_forbid_time(String fp_forbid_time) {
		this.fp_forbid_time = fp_forbid_time;
	}
    /**
    *解封时间
	* @return
    */ 
	public Date getFp_dearchive() {
		return fp_dearchive;
	}
    /**
    *解封时间
	* @param type
    */ 
	public void setFp_dearchive(Date fp_dearchive) {
		this.fp_dearchive = fp_dearchive;
	}
    /**
    *创建人
	* @return
    */ 
	public String getFp_cuser() {
		return fp_cuser;
	}
    /**
    *创建人
	* @param type
    */ 
	public void setFp_cuser(String fp_cuser) {
		this.fp_cuser = fp_cuser;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getFp_cdate() {
		return fp_cdate;
	}
    /**
    *创建时间
	* @param type
    */ 
	public void setFp_cdate(Date fp_cdate) {
		this.fp_cdate = fp_cdate;
	}
    /**
    *修改人
	* @return
    */ 
	public String getFp_updateuser() {
		return fp_updateuser;
	}
    /**
    *修改人
	* @param type
    */ 
	public void setFp_updateuser(String fp_updateuser) {
		this.fp_updateuser = fp_updateuser;
	}
    /**
    *修改时间
	* @return
    */ 
	public Date getFp_updatetime() {
		return fp_updatetime;
	}
    /**
    *修改时间
	* @param type
    */ 
	public void setFp_updatetime(Date fp_updatetime) {
		this.fp_updatetime = fp_updatetime;
	}
    /**
    *状态(0：禁言；1：解封)
	* @return
    */ 
	public int getFp_status() {
		return fp_status;
	}
    /**
    *状态(0：禁言；1：解封)
	* @param type
    */ 
	public void setFp_status(int fp_status) {
		this.fp_status = fp_status;
	}
	/**
    *描述ID
	* @return
    */ 
	public String getPd_id() {
		return pd_id;
	}
    /**
    *描述ID
	* @param type
    */ 
	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}
    /**
    *评论ID
	* @return
    */ 
	public String getPc_id() {
		return pc_id;
	}
    /**
    *评论ID
	* @param type
    */ 
	public void setPc_id(String pc_id) {
		this.pc_id = pc_id;
	}
    /**
    *回复ID
	* @return
    */ 
	public String getPr_id() {
		return pr_id;
	}
    /**
    *回复ID
	* @param type
    */ 
	public void setPr_id(String pr_id) {
		this.pr_id = pr_id;
	}
}
